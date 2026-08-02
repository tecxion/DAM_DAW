public class CatalogoTienda {

    static void main() {
        System.out.println("CATÁLOGO DE LA TIENDA (VIDEOJUEGOS)");

        // Crear instancia de VideojuegoBean usando el constructor sin argumentos
        VideojuegoBean videojuegoBean = new VideojuegoBean();

        // Mostrar las propiedades del primer juego usando un getter
        System.out.println("Primer videojuego: " + videojuegoBean.getTitulo() +
                " - Precio: " + videojuegoBean.getPrecio() + "€");

        // Probar la navegación hacia adelante
        videojuegoBean.siguienteJuego();
        videojuegoBean.siguienteJuego();
        videojuegoBean.siguienteJuego();

        System.out.println("Cuarto videojuego: " + videojuegoBean.getTitulo() +
                " - Precio: " + videojuegoBean.getPrecio() + "€");

        videojuegoBean.siguienteJuego(); // No avanzará porque solo hay 4 en el catálogo

        // Probar la navegación hacia atrás
        videojuegoBean.anteriorJuego();
        System.out.println("Tercer videojuego: " + videojuegoBean.getTitulo() +
                " - Precio: " + videojuegoBean.getPrecio() + "€");

        // Volver a probar la navegación hacia atrás
        videojuegoBean.anteriorJuego();
        System.out.println("Precio del segundo videojuego: " + videojuegoBean.getPrecio());
    }
}
