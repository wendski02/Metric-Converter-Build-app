package com.example.metricconverter2;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class TIme extends AppCompatActivity {

    private EditText editTextTime;
    private Spinner spinnerFromUnit, spinnerToUnit;
    private Button buttonConvert;
    private TextView textViewResult;

    public ImageView mass, temp, length ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        editTextTime = findViewById(R.id.editTextTime);
        spinnerFromUnit = findViewById(R.id.spinnerFromUnit);
        spinnerToUnit = findViewById(R.id.spinnerToUnit);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        mass = findViewById(R.id.mass);
        temp = findViewById(R.id.temp);
        length = findViewById(R.id.length);

        // Mengisi spinner dengan daftar satuan panjang
        String[] timeUnits = {"second", "minute", "hour"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromUnit.setAdapter(adapter);
        spinnerToUnit.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTime();
            }
        });

        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TIme.this,Mass.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TIme.this,Temp.class);
                startActivity(intent);
            }
        });

        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TIme.this,Length.class);
                startActivity(intent);
            }
        });

    }

    private void convertTime() {
        double inputValue = Double.parseDouble(editTextTime.getText().toString());
        String fromUnit = spinnerFromUnit.getSelectedItem().toString();
        String toUnit = spinnerToUnit.getSelectedItem().toString();
        double result = 0;

        // Konversi satuan panjang sesuai dengan satuan awal dan satuan tujuan yang dipilih
        switch (fromUnit) {
            case "second":
                result = convertFromSecond(inputValue, toUnit);
                break;
            case "minute":
                result = convertFromMinute(inputValue, toUnit);
                break;
            case "hour":
                result = convertFromHour(inputValue, toUnit);
                break;

        }

        textViewResult.setText("Result: " + result + " " + toUnit);
    }

    private double convertFromSecond(double value, String toUnit) {
        double result = 0;

        switch (toUnit) {
            case "second":
                result = value;
                break;
            case "minute":
                result = value / 60;
                break;
            case "hour":
                result = value / 3600;
                break;
        }
        return result;
    }

    private double convertFromMinute(double value, String toUnit) {
        double result = 0;


        switch (toUnit) {
            case "second":
                result = value * 60;
                break;
            case "hour":
                result = value / 60;
                break;
            default:
                result = value; // Jika satuan tujuan sama dengan sentimeter, hasilnya tetap sama
                break;
        }

        return result;
    }


    private double convertFromHour(double value, String toUnit) {
        double result = 0;



        switch (toUnit) {
            case "second":
                result = value * 3600;
                break;
            case "minute":
                result = value * 60;
                break;
            default:
                result = value;
                break;

        }

        return result;
    }

}