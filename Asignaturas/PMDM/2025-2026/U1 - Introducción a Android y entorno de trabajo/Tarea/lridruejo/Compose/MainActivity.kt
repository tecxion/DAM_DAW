import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Clase principal (actividad principal) que hereda de la clase ComponentActivity
class MainActivity : ComponentActivity() {
    // Sobrecarga del método onCreate que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase padre
        enableEdgeToEdge() // Habilita el modo pantalla completa
        // setContent para definir la UI con Compose
        setContent {
            Paisaje()
        }
    }
}

// Función composable que representa la pantalla principal de la aplicación
@Composable
fun Paisaje() {
    // Column: Contenedor principal para disposición vertical
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla disponible
            .padding(top = 100.dp) // Margen superior
    ) {
        // Text: Texto de bienvenida
        Text(
            text = "¡Bienvenido Román!",
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Centrado horizontalmente
        )

        // Box: Contenedor que puede superponer elementos
        Box(
            modifier = Modifier
                .fillMaxWidth() // Ocupa todo el ancho disponible
                .padding(top = 50.dp) // Margen superior
                .background(Color(color = 0xFFFFF294)) // Color amarillo claro de fondo
        ) {
            // Column: Columna interna para organizar el contenido del Box
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 10.dp) // Márgenes laterales
                    .padding(vertical = 20.dp) // Márgenes verticales
            ) {
                // Text: Texto descriptivo
                Text(
                    text = "Este es mi paisaje favorito"
                )

                // Image: Imagen del paisaje
                Image(
                    painter = painterResource(id = R.drawable.paisaje), // Referencia al recurso
                    contentDescription = "Mi paisaje favorito", // Texto de accesibilidad
                    modifier = Modifier
                        .padding(vertical = 20.dp) // Márgenes verticales
                )

                // Text: Pie de foto
                Text(
                    text = "Paisaje Tranquilo"
                )
            }
        }
    }
}

// Previsualización en Android Studio
@Preview(showBackground = true) // Muestra el fondo en la previsualización
@Composable
fun PaisajePreview() {
    Paisaje()
}