import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clases pertenecientes a la importación en Maven de la librería org.json
// https://mvnrepository.com/artifact/org.json/json/20250107
import org.json.JSONArray;
import org.json.JSONObject;

class SolicitaDatosAEMET {

    private static final String AEMET_API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJscmlkcnVlam8zMDhxQGZwZHJpb2phLmNvbSIsI"
            + "mp0aSI6IjI4MTA2N2IyLTRmOTItNGIxOS05MGI3LWE5M2ViNWVlN2FmNiIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNzcyMzczMTgzLCJ1c"
            + "2VySWQiOiIyODEwNjdiMi00ZjkyLTRiMTktOTBiNy1hOTNlYjVlZTdhZjYiLCJyb2xlIjoiIn0.4dniesOiUCDIo14wp8xdBi04QuM9Y"
            + "_tC6KWBBEA1fag";
    private static final String AEMET_URL_API = "https://opendata.aemet.es/opendata";

    /*
     * URL de la AEMET que proporciona el inventario completo de estaciones meteorológicas (con sus IDEMA) con los que
     * hacer la consulta para una determinada localidad
     */
    private static final String AEMET_URL_TODAS_LAS_ESTACIONES_METEOROLOGICAS = AEMET_URL_API
            + "/api/valores/climatologicos/inventarioestaciones/todasestaciones";

    /*
     * URL de la AEMET que proporciona, por rango de fechas, los datos climatológicos diarios para una ciudad
     *
     * Uno de los parámetros ara esta consulta es el valor IDEMA (código identificador de la estación meteorológica)
     * vinculado a la localidad
     * /api/valores/climatologicos/diarios/datos/fechaInicio/{fechaInicioStr}/fechaFin/{fechaFinStr}/estacion/{idema}
     */
    private static final String AEMET_URL_VALORES_CLIMA_DIARIOS = AEMET_URL_API
            + "/api/valores/climatologicos/diarios/datos";

    // Fecha inicial del rango de fechas en el que se desea saber datos de la localidad
    private static final String FECHA_INICIO = "2025-01-01T00:00:00UTC";

    // Fecha final del rango de fechas en el que se desea saber datos de la localidad
    private static final String FECHA_FIN = "2025-01-02T00:00:00UTC";

    // Método para obtener la temperatura mínima de una ciudad
    static String tempMinimaCiudad(String ciudad) {
        String respuesta = "";

        // Obtener IDEMA de la estación asociada a la ciudad
        String idema = getIDEMA(ciudad);

        if (!idema.isEmpty()) {
            // Se ha localizado un código IDEMA para la ciudad solicitada

            /*
             * Petición al servidor de la AEMET empleando el comando cURL (es necesario que esté instalado en el equipo)
             * Esta petición devuelve toda la información que está almacenada en el sistema, incluyendo la temperatura
             * mínima, sobre una estación dado su IDEMA y un rango de fechas
             */
            String[] primeraConsulta = {
                    "curl",
                    "-X", "GET", AEMET_URL_VALORES_CLIMA_DIARIOS
                    + "/fechaini/" + FECHA_INICIO.replace(":", "%3A")
                    + "/fechafin/" + FECHA_FIN.replace(":", "%3A")
                    + "/estacion/" + idema,
                    "-H", "accept: application/json",
                    "-H", "api_key: " + AEMET_API_KEY
            };
            Process proceso = null;

            try {
                proceso = Runtime.getRuntime().exec(primeraConsulta);
            } catch (IOException e) {
                Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
            }

            // Procesar el resultado devuelto en caso de que no haya habido errores
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream(), StandardCharsets.ISO_8859_1)
            );
            String linea;

            try {
                while ((linea = br.readLine()) != null) {
                    respuesta += linea;
                }
            } catch (IOException e) {
                Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
            }

            // Convertir la respuesta en un JSONObject
            JSONObject elemento = new JSONObject(respuesta);

            // Guardar la URL que proporciona los datos de esa estación para ese rango de fechas
            respuesta = elemento.getString("datos");

            // Segunda consulta al servidor, encadenada con la anterior, que contiene, entre otros, el valor de la
            // temperatura mínima de todas las ciudades asociadas a esa estación
            String[] segundaConsulta = {"curl", "-X", "GET", respuesta};
            proceso = null;

            try {
                proceso = Runtime.getRuntime().exec(segundaConsulta);
            } catch (IOException e) {
                Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
            }

            // Procesar el resultado devuelto en caso de que no haya habido errores
            br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.ISO_8859_1));
            respuesta = "";

            try {
                while ((linea = br.readLine()) != null) {
                    respuesta += linea;
                }
            } catch (IOException e) {
                Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
            }

            // Convertir la respuesta en un JSONObject
            elemento = new JSONObject(respuesta.replace("[", "").replace("]", ""));

            // Seleccionar el valor de la temperatura mínima
            respuesta = elemento.getString("tmin");
        }

        return respuesta + " grados (ciudad '" + ciudad + "' a fecha " + FECHA_INICIO + ")";
    }

    // Método para obtener el código identificador de la estación meteorológica (IDEMA) para una ciudad
    static String getIDEMA(String ciudad) {
        /*
         * Petición al servidor de la AEMET empleando el comando cURL (necesario tenerlo instalado en el equipo)
         * Esta petición devuelve toda la información que está almacenada en el sistema relativo a las estaciones,
         * con sus códigos IDEMA, donde se localiza la que da servicio a la localidad deseada
         */
        String[] primeraConsulta = {
                "curl",
                "-X", "GET", AEMET_URL_TODAS_LAS_ESTACIONES_METEOROLOGICAS,
                "-H", "accept: application/json",
                "-H", "api_key: " + AEMET_API_KEY
        };
        Process proceso = null;

        try {
            proceso = Runtime.getRuntime().exec(primeraConsulta);
        } catch (IOException e) {
            Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
        }

        // Procesar resultado devuelto en caso de que no haya habido errores
        BufferedReader br = new BufferedReader(
                new InputStreamReader(proceso.getInputStream(), StandardCharsets.ISO_8859_1)
        );
        String linea;
        String respuesta = "";

        try {
            while ((linea = br.readLine()) != null) {
                respuesta += linea;
            }
        } catch (IOException e) {
            Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
        }

        // Convertir respuesta en un JSONObject
        JSONObject elemento = new JSONObject(respuesta);

        // Guardar la URL que proporciona los datos de todas las estaciones
        respuesta = elemento.getString("datos");

        // Segunda consulta al servidor, encadenada con la anterior, que obtiene, entre otros, el valor de los códigos
        // IDEMA de las estaciones y las localidades asociadas
        String[] segundaConsulta = {"curl", "-X", "GET", respuesta};
        proceso = null;

        try {
            proceso = Runtime.getRuntime().exec(segundaConsulta);
        } catch (IOException e) {
            Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
        }

        // Procesar resultado devuelto en caso de que no haya habido errores
        br = new BufferedReader(new InputStreamReader(proceso.getInputStream(), StandardCharsets.ISO_8859_1));
        respuesta = "";

        try {
            while ((linea = br.readLine()) != null) {
                // Agregar los valores de los elementos deseados
                if (linea.contains("{")  // Inicio elemento JSON
                        || linea.contains("indicativo")
                        || linea.contains("nombre")
                        || linea.contains("}")) {  // Fin elemento JSON
                    if (linea.contains("nombre")) {
                        // Para obtener un elemento JSON bien formado hay que quitar la coma final después del par
                        // clave-valor "nombre"
                        respuesta += linea.replace("\",", "\"");  // ", para que sea la coma final
                    } else {
                        respuesta += linea;
                    }
                }
            }
        } catch (IOException e) {
            Logger.getLogger(SolicitaDatosAEMET.class.getName()).log(Level.SEVERE, null, e);
        }

        // Convertir respuesta en un JSONArray
        JSONArray listaCiudades = new JSONArray(respuesta);

        // Obtener el IDEMA correspondiente a la estación asociada a la localidad deseada
        respuesta = "";

        for (int i = 0; i < listaCiudades.length(); i++) {
            if (listaCiudades.getJSONObject(i).getString("nombre").contains(ciudad.toUpperCase())) {
                respuesta = listaCiudades.getJSONObject(i).getString("indicativo");
            }
        }

        return respuesta;
    }

}
