package com.example.metricconverter2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Temp extends AppCompatActivity {

    private EditText editTextCelsius;
    private Button buttonConvert;
    private TextView textViewFahrenheit, textViewReamur, textViewKelvin;

    public ImageView mass, length, time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewFahrenheit = findViewById(R.id.textViewFahrenheit);
        textViewReamur = findViewById(R.id.textViewReamur);
        textViewKelvin = findViewById(R.id.textViewKelvin);

        mass = findViewById(R.id.mass);
        length = findViewById(R.id.length);
        time = findViewById(R.id.time);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature();
            }
        });

        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Temp.this,Mass.class);
                startActivity(intent);
            }
        });

        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Temp.this,Length.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Temp.this,TIme.class);
                startActivity(intent);
            }
        });


    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(editTextCelsius.getText().toString());

            double fahrenheit = (celsius * 9/5) + 32;
            double reamur = celsius * 4/5;
            double kelvin = celsius + 273.15;

            textViewFahrenheit.setText("Fahrenheit  : " + fahrenheit + " °F");
            textViewReamur.setText("Reamur        : " + reamur + " °Re");
            textViewKelvin.setText("Kelvin          : " + kelvin + " K");
        } catch (NumberFormatException e) {
            // Handle error jika input tidak valid
            e.printStackTrace();
        }
    }
}
