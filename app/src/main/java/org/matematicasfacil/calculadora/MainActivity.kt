package org.matematicasfacil.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img_imagen = findViewById(R.id.imageView);
        EditText dato1 = findViewById(R.id.editTextText1);
        EditText dato2 = findViewById(R.id.editTextText2);
        Button btn_adicion = findViewById(R.id.button1);
        Button btn_sustraccion = findViewById(R.id.button2);
        Button btn_multiplicacion = findViewById(R.id.button3);
        Button btn_division = findViewById(R.id.button4);
        Button btn_cerrar = findViewById(R.id.button5);
        TextView resultado = findViewById(R.id.textView);
        img_imagen.setImageResource(R.drawable.calculator);

        Operacion suma = (a, b) -> a + b;
        Operacion resta = (a, b) -> a - b;
        Operacion multiplicacion = (a, b) -> a * b;
        Operacion division = (a, b) -> a / b;

        View.OnClickListener click = v -> {

            if (v==btn_cerrar){
                finish();// Cierra la actividad actual
                //finishAffinity(); // Finaliza todas las actividades en el stack
                //System.exit(0); // Cierra por completo la aplicación
            }

            if (v==btn_adicion & v==btn_sustraccion & v==btn_multiplicacion & v==btn_division &
                dato1.getText().toString().isBlank()||dato2.getText().toString().isBlank()){
                Toast.makeText(getBaseContext(),"Falta ingresar números", Toast.LENGTH_SHORT).show();
                return;
            }

            int n1 = Integer.parseInt(dato1.getText().toString());
            int n2 = Integer.parseInt(dato2.getText().toString());

            if(v==btn_division & n2==0){
                Toast.makeText(getBaseContext(),"No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                return;
            }

            if(v == btn_adicion){
                resultado.setText(suma.apply(n1, n2) + "");
            } else if (v == btn_sustraccion) {
                resultado.setText(resta.apply(n1, n2) + "");
            } else if (v == btn_multiplicacion) {
                resultado.setText(multiplicacion.apply(n1, n2) + "");
            } else if (v == btn_division) {
                resultado.setText(division.apply(n1, n2) + "");
            }
        };
        btn_adicion.setOnClickListener(click);
        btn_sustraccion.setOnClickListener(click);
        btn_multiplicacion.setOnClickListener(click);
        btn_division.setOnClickListener(click);
        btn_cerrar.setOnClickListener(click);
    }
}