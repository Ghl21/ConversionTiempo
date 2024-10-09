package com.example.conversiontiempo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    String valorEditText, selectedItem1, selectedItem2, Resultado;
    Double v1, v2, v3, v4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner_example);
        Spinner spinner2 = findViewById(R.id.spinner_example2);
        EditText editText = findViewById(R.id.edtConvertir);
        Button btn1 = findViewById(R.id.btnConvertir);
        TextView txvResultado = findViewById(R.id.txvResultado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                valorEditText = editText.getText().toString();
                selectedItem1 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             v1 = Double.parseDouble(editText.getText().toString());
             v2 = obtenerValorUno(selectedItem1.toUpperCase(), v1);
             v3 = obtenerValorDos(selectedItem2.toUpperCase(), v2);
                Resultado = String.valueOf(v4);

                txvResultado.setVisibility(View.VISIBLE);
                txvResultado.setText("la conversión de "+ editText.getText().toString() + " " + selectedItem1 + " a " + selectedItem2 + " es: " + Resultado + " " + selectedItem2);
            }

        });

    }
    public double obtenerValorUno(String tipo, double valorEditText)
    {
        if (tipo.equals("SEGUNDOS")) {
            v2 = v1;
        } else if (tipo.equals("MINUTOS")) {
            v2 = v1 * 60;
        } else if (tipo.equals("HORAS")) {
            v2 = v1 * 3600;

        }
        return v2;
    }

    public double obtenerValorDos(String tipo, double valorDos)
    {
        if(tipo.equals("SEGUNDOS"))
        {
            v4 = valorDos;
        }
        else if(tipo.equals("MINUTOS"))
        {
            v4 = valorDos/60;
        }else if(tipo.equals("HORAS"))
        {
            v4 = valorDos/3600;
        }

        return v4;
    }

}


