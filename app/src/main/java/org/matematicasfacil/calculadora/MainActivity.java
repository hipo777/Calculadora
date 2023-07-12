package org.matematicasfacil.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.matematicasfacil.calculadora.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View.OnClickListener click = v -> {

            if (v==binding.btnCerrar){
                //finish();// Cierra la actividad actual
                //finishAffinity(); // Finaliza todas las actividades en el stack
                //System.exit(0); // Cierra por completo la aplicación
                finishAndRemoveTask();//finaliza actividad actual y eliminaa de la pila de actividades
            }

            if (v==binding.btnAdicion & v==binding.btnSustraccion & v==binding.btnMultiplicacion & v==binding.btnAdicion &
                    binding.eT1.getText().toString().isBlank()||binding.eT2.getText().toString().isBlank()){
                Toast.makeText(getBaseContext(),"Falta ingresar números", Toast.LENGTH_SHORT).show();
                return;
            }

            double n1 = Integer.parseInt(binding.eT1.getText().toString());
            double n2 = Integer.parseInt(binding.eT2.getText().toString());

            if(v==binding.btnDivision & n2==0){
                Toast.makeText(getBaseContext(),"ERROR", Toast.LENGTH_SHORT).show();
                return;
            }

            if(v == binding.btnAdicion){
                double result = n1 + n2;
                binding.tvResultado.setText(String.valueOf(result));
            } else if (v == binding.btnSustraccion) {
                double result = n1 - n2;
                binding.tvResultado.setText(String.valueOf(result));
            } else if (v == binding.btnMultiplicacion) {
                double result = n1 * n2;
                binding.tvResultado.setText(String.valueOf(result));
            } else if (v == binding.btnDivision) {
                double result = n1 / n2;
                binding.tvResultado.setText(String.valueOf(result));
            }
        };

        binding.btnAdicion.setOnClickListener(click);
        binding.btnSustraccion.setOnClickListener(click);
        binding.btnMultiplicacion.setOnClickListener(click);
        binding.btnDivision.setOnClickListener(click);
        binding.btnCerrar.setOnClickListener(click);
    }
}