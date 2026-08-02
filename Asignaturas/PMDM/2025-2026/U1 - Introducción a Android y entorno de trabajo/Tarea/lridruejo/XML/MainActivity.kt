import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// Clase principal (actividad principal) que hereda de la clase AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Sobrecarga del método onCreate que se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase padre
        enableEdgeToEdge() // Habilita el modo pantalla completa
        setContentView(R.layout.activity_main) // Establece el layout XML como contenido de la actividad
    }
}