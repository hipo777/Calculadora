package org.matematicasfacil.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.matematicasfacil.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val click = View.OnClickListener { v: View ->
            if (v == binding.btnCerrar) {
                //finish();// Cierra la actividad actual
                //finishAffinity(); // Finaliza todas las actividades en el stack
                //System.exit(0); // Cierra por completo la aplicación
                finishAndRemoveTask() //finaliza actividad actual y eliminaa de la pila de actividades
            }
            if ((v == binding.btnAdicion) and (v == binding.btnSustraccion) and (v == binding.btnMultiplicacion) and (v == binding.btnAdicion) and
                binding.eT1.text.toString().isBlank() || binding.eT2.text.toString()
                    .isBlank()
            ) {
                Toast.makeText(baseContext, "Falta ingresar números", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            val n1 = binding.eT1.text.toString().toDouble()
            val n2 = binding.eT2.text.toString().toDouble()

            if ((v == binding.btnDivision) and (n2 == 0.0)) {
                Toast.makeText(baseContext, "ERROR", Toast.LENGTH_SHORT).show()
                return@OnClickListener
            }
            if (v == binding.btnAdicion) {
                val result = n1 + n2
                binding.tvResultado.text = result.toString()
            } else if (v == binding.btnSustraccion) {
                val result = n1 - n2
                binding.tvResultado.text = result.toString()
            } else if (v == binding.btnMultiplicacion) {
                val result = n1 * n2
                binding.tvResultado.text = result.toString()
            } else if (v == binding.btnDivision) {
                val result = n1 / n2
                binding.tvResultado.text = result.toString()
            }
        }
        binding.btnAdicion.setOnClickListener(click)
        binding.btnSustraccion.setOnClickListener(click)
        binding.btnMultiplicacion.setOnClickListener(click)
        binding.btnDivision.setOnClickListener(click)
        binding.btnCerrar.setOnClickListener(click)
    }
}