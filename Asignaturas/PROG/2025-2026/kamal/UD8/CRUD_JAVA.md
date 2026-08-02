Acceso a Datos con Java y MariaDB (JDBC)

Esta guía resume todo lo necesario para dominar el consumo de bases de datos relacionales en Java, siguiendo el patrón **DAO (Data Access Object)** y las mejores prácticas de la industria. Diseñada para ser entendida incluso tras un largo tiempo sin tocar el código.

---

## 1. El Ecosistema JDBC (La Teoría)

**JDBC (Java Database Connectivity)** es el estándar de Java que permite interactuar con cualquier base de datos relacional. 
*   **Driver:** Es el "traductor". Sin el driver de MariaDB (el archivo `.jar`), Java no sabe cómo enviarle comandos al servidor.
*   **URL de Conexión:** Es la dirección física del recurso. Formato: `jdbc:mariadb://[host]:[puerto]/[nombre_bd]`
    *   Ejemplo: `jdbc:mariadb://localhost:3306/peliculas`
    *   `3306`: Es el puerto estándar de MariaDB/MySQL.

---

## 2. Configuración del Proyecto (Maven)
Para que las clases del paquete `java.sql.*` puedan comunicarse con el servidor, debemos incluir la dependencia del conector en el archivo `pom.xml`:

```xml
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <version>3.5.8</version>
</dependency>
```

---

## 3. La Clase Modelo (POJO)
Representa una fila de tu tabla de la base de datos como un objeto Java.
**Punto Crítico:** Al usar métodos como `.trim()`, siempre debes proteger el código contra valores nulos para evitar el temido `NullPointerException`.

```java
public class Pelicula {
    private String titulo;
    
    public void setTitulo(String titulo) {
        // Validación de seguridad obligatoria
        if (titulo != null) {
            this.titulo = titulo.trim();
        } else {
            this.titulo = null;
        }
    }
    
    public String getTitulo() {
        return (titulo != null) ? titulo.trim() : null;
    }
}
```

---

## 4. Gestión de la Conexión (`ConnectionDB`)
Su misión es centralizar la apertura del "túnel" de comunicación.

*   **`DriverManager.getConnection(url, user, pass)`**: Es el método que negocia la entrada.
*   **Importante:** La conexión es un recurso finito y pesado. Siempre debe cerrarse al terminar el programa o la tarea.

---

## 5. El Corazón del Código: La Capa DAO (Data Access Object)
Aquí es donde reside la lógica SQL. El DAO aísla la base de datos del resto de la aplicación.

### 5.1. El Estándar: `try-with-resources`
Es la mejor práctica en Java moderno. Los recursos declarados en el paréntesis del `try` se cierran **automáticamente** al finalizar el bloque, incluso si ocurre un error. Evita fugas de memoria (Memory Leaks).

### 5.2. CREATE / UPDATE / DELETE (Modificar datos)
Para estas operaciones se usa **`PreparedStatement`** y el método **`executeUpdate()`**.

```java
// Ejemplo: Actualizar duración de una película
String sql = "UPDATE catalogo SET duracion_minutos = ? WHERE Titulo = ?";

try (PreparedStatement ps = conexion.prepareStatement(sql)) {
    // Los índices de los parámetros '?' EMPIEZAN EN 1
    ps.setInt(1, 120); 
    ps.setString(2, "Origen");
    
    // executeUpdate() devuelve un entero con las filas afectadas
    int filasCambiadas = ps.executeUpdate(); 
} catch (SQLException e) {
    System.out.println("Error en la operación: " + e.getMessage());
}
```

### 5.3. READ (Consultar datos)
Para leer se usa **`ResultSet`**, que funciona como un cursor que recorre los resultados fila a fila.

```java
String sql = "SELECT Titulo, director FROM catalogo";

try (PreparedStatement ps = conexion.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) { // executeQuery() devuelve un ResultSet
    
    // .next() mueve el cursor a la siguiente fila. Devuelve FALSE si no hay más.
    while (rs.next()) { 
        String t = rs.getString("Titulo"); // Se puede leer por nombre de columna
        String d = rs.getString(2);        // O por índice de la consulta (director)
    }
} catch (SQLException e) { ... }
```

---

## 6. Resumen de Métodos y Retornos (Chuleta)

| Método Java | Operación SQL | Retorno |
| :--- | :--- | :--- |
| **`executeUpdate()`** | `INSERT`, `UPDATE`, `DELETE` | `int` (filas que cambiaron). |
| **`executeQuery()`** | `SELECT` | `ResultSet` (los datos leídos). |

---

## 7. Cabos Sueltos que No Debes Olvidar 🚩

1.  **Índices JDBC:** Los parámetros `?` se cuentan desde **1**. (Error típico: empezar en 0).
2.  **El método `.next()`**: El `ResultSet` inicialmente apunta "antes de la primera fila". Siempre hay que llamar a `.next()` para empezar a leer, incluso si solo hay un resultado (como en un `count`).
3.  **SQLException**: Es una excepción de tipo *checked*. Java te obliga a usar `try-catch` o a declararla con `throws`.
4.  **SQL Injection**: **Nunca** concatenes variables en el String SQL. Usa siempre `?` y `ps.setXXX()`. Esto limpia los datos antes de enviarlos.
5.  **Cierre de Conexión**: Aunque los Statements se cierren con `try-with-resources`, la **Connection** principal debe cerrarse al final de la aplicación en el método `main`.

---
## 8. Teoría para Repaso (Preguntas Típicas)
*   **¿Qué es un ResultSet?** Es una estructura de datos que contiene los resultados de una consulta `SELECT`. Permite iterar sobre las filas devueltas.
*   **¿Por qué es mejor `PreparedStatement` que `Statement`?** Por dos razones: **Seguridad** (protege contra inyección SQL) y **Rendimiento** (la base de datos pre-compila la sentencia).
*   **¿Qué hace el Driver JDBC?** Actúa como un adaptador que traduce las llamadas de Java al protocolo específico que entiende el gestor de base de datos (MariaDB).
```
