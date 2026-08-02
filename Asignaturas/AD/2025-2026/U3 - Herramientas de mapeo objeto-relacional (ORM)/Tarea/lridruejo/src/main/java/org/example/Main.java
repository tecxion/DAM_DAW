package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("SupermercadoPU");
            em = emf.createEntityManager();

            // 1. Listar productos y proveedores
            listarProductosYProveedores(em);

            // 2. Crear nuevos tickets con líneas de compra
            crearNuevosTickets(em);

            // 3. Calcular ingresos por producto específico
            calcularIngresosPorProducto(em, 2);

            // 4. Historial de ventas de un producto específico
            obtenerHistorialVentasProducto(em, 3);
        } catch (Exception e) {
            System.err.println("Error durante la ejecución de la aplicación");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

            // Rollback por seguridad
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }

    // 1. Listar productos y proveedores
    public static void listarProductosYProveedores(EntityManager em) {
        System.out.println("----- LISTA DE PRODUCTOS Y PROVEEDORES -----");

        // Consulta para seleccionar todos los productos (p)
        // left join p.proveedor -> Hace un LEFT JOIN con la entidad Proveedor (left para que incluya productos sin proveedor)
        // fetch -> Carga inmediatamente los datos del proveedor (evita Lazy Loading: otra consulta por producto)
        String jpql = "FROM Producto p LEFT JOIN FETCH p.proveedor";
        // Producto.class -> Los resultados de la consulta son de tipo Producto
        List<Producto> productos = em.createQuery(jpql, Producto.class).getResultList();

        if (productos.isEmpty()) {
            System.out.println("No hay productos");
        } else {
            // Iteración sobre cada producto de la lista
            for (Producto producto : productos) {
                // Sin el left join fetch, getProveedor() volvería a hacer una consulta con cada producto
                System.out.println(producto.getNombre() + ", Proveedor: " +
                        (producto.getProveedor() != null ? producto.getProveedor().getNombre() : "Sin proveedor"));
            }

            System.out.println("----- FIN DE PRODUCTOS Y PROVEEDORES -----");
        }

        System.out.println();
    }


    // 2. Crear nuevos tickets con líneas de compra
    public static void crearNuevosTickets(EntityManager em) {
        System.out.println("----- CREANDO TICKETS -----");

        // Inicio una transacción con la base de datos
        em.getTransaction().begin();

        Producto prodId1 = em.find(Producto.class, 1);
        Producto prodId2 = em.find(Producto.class, 2);
        Producto prodId3 = em.find(Producto.class, 3);

            // Si hubiera muchos productos, sería más eficiente hacer una sola consulta y guardar los resultados en una colección
            /*
            listaIdProductos = [1, 2, 3, 6...];
            String jpql = "SELECT p FROM Producto p WHERE p.id IN :ids";
            Map<Integer, Producto> productos = em.createQuery(jpql, Producto.class)
                .setParameter("ids", listaIdProductos)
                getResultList().stream()
                .collect(Collectors.toMap(Producto::getId, p -> p));
            Y luego usaríamos productos.get(idProducto) en la llamada al método crearLineaCompra
            */

        // Ticket 1
        Ticket ticket1 = new Ticket();
        ticket1.setCodigoTicket("T-004");
        ticket1.setFecha(LocalDate.now());
        ticket1.setUbicacionTienda("Madrid Sur");
        em.persist(ticket1);

        // Líneas de compra del Ticket 1
        crearLineaCompra(em, ticket1, prodId1, 3);
        crearLineaCompra(em, ticket1, prodId2, 2);

        // Ticket 2
        Ticket ticket2 = new Ticket();
        ticket2.setCodigoTicket("T-005");
        ticket2.setFecha(LocalDate.now());
        ticket2.setUbicacionTienda("Logroño Norte");
        em.persist(ticket2);

        // Líneas de compra del Ticket 2
        crearLineaCompra(em, ticket2, prodId1, 1);
        crearLineaCompra(em, ticket2, prodId2, 3);
        crearLineaCompra(em, ticket2, prodId3, 2);

        // Hago commit en la base de datos
        em.getTransaction().commit();

        System.out.println("----- TICKETS CREADOS -----");
        System.out.println();
    }

    public static void crearLineaCompra(EntityManager em, Ticket tckt, Producto prod, int cantidad) {
        // Validaciones
        if (tckt == null) {
            throw new IllegalArgumentException("El ticket no puede ser nulo");
        }
        if (prod == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (prod.getPrecio() == null) {
            throw new IllegalArgumentException("El producto " + prod.getNombre() + " (ID: " + prod.getId() + ") no tiene precio definido");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("El cantidad no puede ser menor o igual que 0");
        }

        LineaCompra lc = new LineaCompra();
        lc.setProducto(prod);
        lc.setTicket(tckt);
        lc.setCantidad(cantidad);
        lc.setSubtotal(prod.getPrecio().multiply(BigDecimal.valueOf(cantidad)));
        em.persist(lc);
    }

    // 3. Calcular ingresos por producto específico
    public static void calcularIngresosPorProducto(EntityManager em, int idProducto) {
        System.out.println("----- CALCULANDO INGRESOS POR PRODUCTO -----");

        Producto producto = em.find(Producto.class, idProducto);
        if (producto == null) {
            System.out.println("El producto con ID " + idProducto + " no está registrado");
            return;
        }

        // Consulta para obtener la suma de todos los subtotales de este producto
        String jpql = "SELECT SUM(lc.subtotal) FROM LineaCompra lc WHERE lc.producto.id = :idProducto";
        BigDecimal ingresos = em.createQuery(jpql, BigDecimal.class).setParameter("idProducto", idProducto).getSingleResult();
        if (ingresos == null) {
            ingresos = BigDecimal.ZERO;
        }

        System.out.printf("Producto: %s (ID: %d)%n", producto.getNombre(), idProducto);
        System.out.printf("Total de ingresos generados: %.2f€%n", ingresos);
        System.out.println("----- FIN CÁLCULO INGRESOS POR PRODUCTO -----");
        System.out.println();
    }

    // 4. Historial de ventas de un producto específico
    public static void obtenerHistorialVentasProducto(EntityManager em, int idProducto) {
        System.out.println("----- HISTORIAL DE VENTAS DEL PRODUCTO -----");
        Producto producto = em.find(Producto.class, idProducto);
        if (producto == null) {
            System.out.println("El producto con ID " + idProducto + " no está registrado.");
            return;
        }

        // Consulta para obtener todas las líneas de compra (con su ticket) en las que aparece el producto
        String jpql = "SELECT lc FROM LineaCompra lc JOIN FETCH lc.ticket t WHERE lc.producto.id = :idProducto order by t.fecha";
        List<LineaCompra> ventas = em.createQuery(jpql, LineaCompra.class).setParameter("idProducto", idProducto).getResultList();

        if (ventas.isEmpty()) {
            System.out.println("Este producto no tiene ventas registradas.");
        } else {
            for (LineaCompra venta : ventas) {
                Ticket ticket = venta.getTicket();
                System.out.println("Ticket: " + ticket.getCodigoTicket() + ", " + ticket.getFecha() +
                        "\nCantidad: " + venta.getCantidad() + " - Subtotal: " + venta.getSubtotal() + "€");
                System.out.println("----------------");
            }

            System.out.println();

            int totalUnidades = ventas.stream().mapToInt(LineaCompra::getCantidad).sum();
            BigDecimal totalVentas = ventas.stream().map(LineaCompra::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add);

            System.out.println("Total unidades vendidas: " + totalUnidades);
            System.out.println("Importe total de ventas: " + totalVentas + "€");
        }

        System.out.println("----- FIN HISTORIAL VENTAS -----");
    }
}