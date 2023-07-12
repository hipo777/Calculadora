package org.matematicasfacil.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img_imagen = findViewById<ImageView>(R.id.imageView)
        val dato1 = findViewById<EditText>(R.id.editTextText1)
        val dato2 = findViewById<EditText>(R.id.editTextText2)
        val btn_adicion = findViewById<Button>(R.id.button1)
        val btn_sustraccion = findViewById<Button>(R.id.button2)
        val btn_multiplicacion = findViewById<Button>(R.id.button3)
        val btn_division = findViewById<Button>(R.id.button4)
        val btn_cerrar = findViewById<Button>(R.id.button5)
        val resultado = findViewById<TextView>(R.id.textView)
        img_imagen.setImageResource(R.drawable.calculator)
        val suma = Operacion { a: Int, b: Int -> a + b }
        val resta = Operacion { a: Int, b: Int -> a - b }
        val multiplicacion = Operacion { a: Int, b: Int -> a * b }
        val division = Operacion { a: Int, b: Int -> a / b }
        val click = View.OnClickListener { v: View ->
            if (v === btn_cerrar) {
                finish() // Cierra la actividad actual
                //finishAffinity(); // Finaliza todas las actividades en el stack
                //System.exit(0); // Cierra por completo la aplicación
            }
            if ((v === btn_adicion) and (v === btn_sustraccion) and (v === btn_multiplicacion) and (v === btn_division) and
                dato1.text.toString().isBlank() || dato2.text.toString().isBlank()
            ) {
                Toast.makeText(baseContext, "Falta ingresar números", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val n1 = dato1.text.toString().toInt()
            val n2 = dato2.text.toString().toInt()
            if ((v === btn_division) and (n2 == 0)) {
                Toast.makeText(baseContext, "No se puede dividir por cero", Toast.LENGTH_SHORT)
                    .show()
                return@OnClickListener
            }
            if (v === btn_adicion) {
                resultado.text = suma.apply(n1, n2).toString() + ""
            } else if (v === btn_sustraccion) {
                resultado.text = resta.apply(n1, n2).toString() + ""
            } else if (v === btn_multiplicacion) {
                resultado.text = multiplicacion.apply(n1, n2).toString() + ""
            } else if (v === btn_division) {
                resultado.text = division.apply(n1, n2).toString() + ""
            }
        }
        btn_adicion.setOnClickListener(click)
        btn_sustraccion.setOnClickListener(click)
        btn_multiplicacion.setOnClickListener(click)
        btn_division.setOnClickListener(click)
        btn_cerrar.setOnClickListener(click)
    }
}