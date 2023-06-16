package org.matematicasfacil.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edit_dato_uno;
    private EditText edit_dato_dos;
    private TextView text_developer;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img_imagen = findViewById(R.id.imageView);
        edit_dato_uno = findViewById(R.id.editTextText1);
        edit_dato_dos = findViewById(R.id.editTextText2);
        Button btn_adicion = findViewById(R.id.button1);
        Button btn_sustraccion = findViewById(R.id.button2);
        Button btn_multiplicacion = findViewById(R.id.button3);
        Button btn_division = findViewById(R.id.button4);
        text_developer = findViewById(R.id.textDeveloper);
        text_resultado = findViewById(R.id.textView);
        img_imagen.setImageResource(R.drawable.calculator);

        btn_adicion.setOnClickListener(v -> {
            int sum = suma();
            text_developer.setVisibility(View.INVISIBLE);
            text_resultado.setVisibility(View.VISIBLE);
            text_resultado.setText(String.valueOf(sum));
        });
        btn_sustraccion.setOnClickListener(v -> {
            int res = resta();
            text_developer.setVisibility(View.INVISIBLE);
            text_resultado.setVisibility(View.VISIBLE);
            text_resultado.setText(String.valueOf(res));
        });
        btn_multiplicacion.setOnClickListener(v -> {
            int pro = producto();
            text_developer.setVisibility(View.INVISIBLE);
            text_resultado.setVisibility(View.VISIBLE);
            text_resultado.setText(String.valueOf(pro));
        });
        btn_division.setOnClickListener(v -> {
            int coc = cociente();
            text_developer.setVisibility(View.INVISIBLE);
            text_resultado.setVisibility(View.VISIBLE);
            text_resultado.setText(String.valueOf(coc));
        });
    }

    public int suma() {
        int number1 = Integer.parseInt(edit_dato_uno.getText().toString());
        int number2 = Integer.parseInt(edit_dato_dos.getText().toString());
        return number1 + number2;
    }

    public int resta() {
        int number1 = Integer.parseInt(edit_dato_uno.getText().toString());
        int number2 = Integer.parseInt(edit_dato_dos.getText().toString());
        return number1 - number2;
    }

    public int producto() {
        int number1 = Integer.parseInt(edit_dato_uno.getText().toString());
        int number2 = Integer.parseInt(edit_dato_dos.getText().toString());
        return number1 * number2;
    }

    public int cociente() {
        int number1 = Integer.parseInt(edit_dato_uno.getText().toString());
        int number2 = Integer.parseInt(edit_dato_dos.getText().toString());
        return number1 / number2;
    }

}