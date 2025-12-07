package com.tecxart.kilometers

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

        // Iniciación de las variables.
    private lateinit var spinner: Spinner
    private lateinit var ptxt_Consumo: EditText
    private lateinit var ptxt_Precio: EditText
    private lateinit var btn_Calcular: Button
    private lateinit var txt_Resultado: TextView
    private lateinit var btn_Reset: Button

    private val capacidadesBateria = mapOf( //Declaración del array con la carga total de la batería.
        "Tesla Model 3" to 75.0,
        "Fiat 500e" to 42.0,
        "Renault Zoe" to 52.0,
        "Hyunday Kona" to 64.0
    )

    override fun onCreate(savedInstanceState: Bundle?) { //función principal
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Primero carga la vista

        spinner = findViewById(R.id.spn_Modelo)
        ptxt_Consumo = findViewById(R.id.ptxt_Consumo)
        ptxt_Precio = findViewById(R.id.ptxt_Precio)
        btn_Calcular = findViewById(R.id.btn_calcular)
        txt_Resultado = findViewById(R.id.txt_Resultado)
        btn_Reset = findViewById(R.id.btn_reset)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modelos,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btn_Calcular.setOnClickListener (this)
        btn_Reset.setOnClickListener (this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_calcular -> calcularCosto()
            R.id.btn_reset -> alertaborrar()
        }
    }


    @SuppressLint("SetTextI18n")
    private fun calcularCosto() {  //función para calcular el costo de la energía y el consumo.
        val modeloSeleccionado = spinner.selectedItem.toString()
        if (modeloSeleccionado == "Seleccione un vehículo"){  // sentencia si el usuario no introduce modelo
            txt_Resultado.text = "Por favor, Seleccione un modelo válido"
            return
        }

        val capacidad = capacidadesBateria[modeloSeleccionado] ?: 0.0
        val consumoStr = ptxt_Consumo.text.toString()
        val precioStr = ptxt_Precio.text.toString()

        if (consumoStr.isEmpty() || precioStr.isEmpty()) { // Condicional por si el usuario no introduce datos.
            txt_Resultado.text = "Introduce consumo o precio válidos."
        }

        val consumo = consumoStr.toDoubleOrNull()
        val precio = precioStr.toDoubleOrNull()

        if (consumo == null || precio == null ){ // Por si lo datos introducidos no son correctos.
            txt_Resultado.text = "Los datos introducidos no son correctos."
            return
        }

        // Calcular el gasto y la autonomía.
        val gasto = consumo * precio
        val autonomia = (capacidad / consumo)*100

        txt_Resultado.text = ("El coche $modeloSeleccionado gasta %.2f € de luz para recorrer 100km." +
                " Con una carga completa, su autonomía teórica es de %.0f Km").format(gasto,autonomia)

    }

    private fun reiniciarapp(){ //función para reiniciar la app.
        spinner.setSelection(0)
        ptxt_Consumo.text.clear()
        ptxt_Precio.text.clear()
        txt_Resultado.text = ""
        ptxt_Consumo.requestFocus()
    }

    private fun alertaborrar() { //función para el alertDialog.
        AlertDialog.Builder(this)
            .setTitle("Confirmación")
            .setMessage("¿Estás seguro de que quieres limpiar el formulario?")
            .setPositiveButton("Sí") { dialog, which ->
                reiniciarapp()
            }
            .setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}
