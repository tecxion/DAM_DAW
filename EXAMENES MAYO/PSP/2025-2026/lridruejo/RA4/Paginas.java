class Paginas {

    // "MIME type" y codificación de caracteres
    static final String primeraCabecera = "Content-Type:text/html; charset=utf-8";

    // Página de inicio
    static final String html_index = "<html>"
            + "<head><title>Inicio</title></head>"
            + "<body>"
            + "<h1>¡Hola mundo!</h1>"
            + "<p>Página de inicio que valida un funcionamiento correcto</p>"
            + "</body>"
            + "</html>";

    // Página "No encontrado"
    static final String html_noEncontrado = "<html>"
            + "<head><title>No encontrado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Página no encontrada</h1>"
            + "<p>La página que solicitaste no existe en nuestro "
            + "servidor</p>"
            + "</body>"
            + "</html>";

    // Página "No implementado"
    static final String html_comandoNoImplementado = "<html>"
            + "<head><title>No implementado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Comando no implementado</h1>"
            + "<p>Ha solicitado un comando no implementado en este servidor. "
            + "Solo se atienden peticiones del comando GET</p>"
            + "</body>"
            + "</html>";
}
