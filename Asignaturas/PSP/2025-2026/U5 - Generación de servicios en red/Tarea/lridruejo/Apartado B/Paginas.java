class Paginas {

    // "MIME type" y codificación de caracteres
    static final String primeraCabecera = "Content-Type:text/html; charset=utf-8";

    // Página de inicio
    static final String html_index = "<html>"
            + "<head><title>Inicio</title></head>"
            + "<body>"
            + "<h1>¡Hola mundo!</h1>"
            + "<p>Página de inicio que valida un funcionamiento correcto.</p>"
            + "<p>Visite la página <a href=\"/tempminima\">temperaturas mínimas</a> si desea consultar temperaturas "
            + "mínimas en diversas localidades de España empleando la API REST Open Data de la AEMET.</p>"
            + "<h2>Puede visitar la página con texto de relleno 'Lorem Ipsum' en el siguiente "
            + "<a href=\"/loremipsum\">enlace</a>.</h2>"
            + "<h1>Formulario de ejemplo, vía método POST:</h1>"
            + "<form method=\"post\">"
            + "<label for=\"campo1\">Campo 1: </label>"
            + "<input type=\"text\" id=\"campo1\" name=\"campo1\">"
            + "<br>"
            + "<input type=\"submit\" value=\"Enviar solicitud\">"
            + "</form>"
            + "</body>"
            + "</html>";

    // Página "tempminima" (con placeholder %s para el resultado)
    static final String html_tempminima = "<html>"
            + "<head><title>Temperatura mínima</title></head>"
            + "<body>"
            + "<h1>Resultado de la consulta anterior: %s</h1>"
            + "<h1>Formulario con el cual se puede solicitar, vía método GET, la temperatura mínima de alguna ciudad "
            + "española (siempre consulta en la fecha 1 de enero de 2025 a las 00:00 horas)</h1>"
            + "<form method=\"get\" action=\"/tempminima\">"
            + "<label for=\"ciudad\">Nombre de la ciudad: </label>"
            + "<input type=\"text\" id=\"ciudad\" name=\"ciudad\">"
            + "<strong> (los acentos son importantes: no es lo mismo Cádiz que Cadiz)"
            + "<br>"
            + "<input type=\"submit\" value=\"Enviar solicitud\">"
            + "</form>"
            + "<p><strong>Esta consulta se apoya en el servicio que proporciona la AEMET a través de su API (AEMET "
            + "Open Data API REST) de la cual se puede obtener más información en la URL: "
            + "<a href=\"https://www.aemet.es/es/datos_abiertos/AEMET_OpenData\">"
            + "https://www.aemet.es/es/datos_abiertos/AEMET_OpenData</a></strong></p>"
            + "<h2>Puede regresar a  la página de inicio haciendo clic en este <a href=\"/\">enlace</a>.</h2>"
            + "</body>"
            + "</html>";

    // Página "loremipsum"
    static final String html_loremipsum = "<html>"
            + "<head><title>Lorem Ipsum</title></head>"
            + "<body>"
            + "<h1>Primer párrafo del generador de texto de relleno 'Lorem Ipsum'</h1>"
            + "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In metus augue, auctor quis arcu eget, "
            + "auctor convallis diam. Phasellus commodo imperdiet odio id mollis. Nullam nec arcu lorem. Morbi ipsum "
            + "massa, eleifend et dui id, tincidunt rutrum risus. Curabitur vitae mauris blandit, tincidunt ipsum sit "
            + "amet, faucibus neque. Pellentesque auctor cursus mi id facilisis. Integer non nunc ex. Donec "
            + "consectetur elit quis rutrum cursus.</p>"
            + "<h2>Puede visitar la página de inicio haciendo clic en este <a href=\"/\">enlace</a>.</h2>"
            + "</body>"
            + "</html>";

    // Página "No encontrado"
    static final String html_noEncontrado = "<html>"
            + "<head><title>No encontrado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Página no encontrada</h1>"
            + "<p>La página que solicitaste no existe en nuestro servidor.</p>"
            + "<h2>Puede visitar la página de inicio haciendo clic en este <a href=\"/\">enlace</a>.</h2>"
            + "</body>"
            + "</html>";

    // Página "No implementado"
    static final String html_comandoNoImplementado = "<html>"
            + "<head><title>No implementado</title></head>"
            + "<body>"
            + "<h1>¡ERROR! Comando no implementado</h1>"
            + "<p>Ha solicitado un comando no implementado en este servidor. Solo se atienden peticiones del "
            + "comando GET.</p>"
            + "<h2>Puede visitar la página de inicio haciendo clic en este <a href=\"/\">enlace</a>.</h2>"
            + "</body>"
            + "</html>";

    // Método para formatear la página "tempminima" con el resultado
    static String getHTML_tempminima(String resultado) {
        return String.format(html_tempminima, resultado);
    }
}
