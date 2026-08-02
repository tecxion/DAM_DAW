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

    // Página "Lorem Ipsum"
    static final String html_loremipsum = "<html>"
            + "<head><title>Lorem Ipsum</title></head>"
            + "<body>"
            + "<h1>Primer párrafo del generador de texto de relleno 'Lorem Ipsum'</h1>"
            + "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
            + "In metus augue, auctor quis arcu eget, auctor convallis diam. "
            + "Phasellus commodo imperdiet odio id mollis. Nullam nec arcu lorem. "
            + "Morbi ipsum massa, eleifend et dui id, tincidunt rutrum risus. "
            + "Curabitur vitae mauris blandit, tincidunt ipsum sit amet, faucibus "
            + "neque. Pellentesque auctor cursus mi id facilisis. Integer non nunc "
            + "ex. Donec consectetur elit quis rutrum cursus. </p>"
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
