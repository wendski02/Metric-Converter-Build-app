package com.example.metricconverter2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Length extends AppCompatActivity {

    private EditText editTextLength;
    private Spinner spinnerFromUnit, spinnerToUnit;
    private Button buttonConvert;
    private TextView textViewResult;

    public ImageView mass, temp, time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        editTextLength = findViewById(R.id.editTextLength);
        spinnerFromUnit = findViewById(R.id.spinnerFromUnit);
        spinnerToUnit = findViewById(R.id.spinnerToUnit);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        mass = findViewById(R.id.mass);
        temp = findViewById(R.id.temp);
        time = findViewById(R.id.time);




        // Mengisi spinner dengan daftar satuan panjang
        String[] lengthUnits = {"mm", "cm", "dm", "m", "dam", "hm", "km"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromUnit.setAdapter(adapter);
        spinnerToUnit.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertLength();
            }
        });

        mass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Length.this,Mass.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Length.this,Temp.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Length.this,TIme.class);
                startActivity(intent);
            }
        });



    }

    private void convertLength() {
        double inputValue = Double.parseDouble(editTextLength.getText().toString());
        String fromUnit = spinnerFromUnit.getSelectedItem().toString();
        String toUnit = spinnerToUnit.getSelectedItem().toString();
        double result = 0;

        // Konversi satuan panjang sesuai dengan satuan awal dan satuan tujuan yang dipilih
        switch (fromUnit) {
            case "mm":
                result = convertFromMillimeter(inputValue, toUnit);
                break;
            case "cm":
                result = convertFromCentimeter(inputValue, toUnit);
                break;
            case "dm":
                result = convertFromDecimeter(inputValue, toUnit);
                break;
            case "m":
                result = convertFromMeter(inputValue, toUnit);
                break;
            case "dam":
                result = convertFromDekameter(inputValue, toUnit);
                break;
            case "hm":
                result = convertFromHectometer(inputValue, toUnit);
                break;
            case "km":
                result = convertFromKilometer(inputValue, toUnit);
                break;


        }

        textViewResult.setText("Result: " + result + " " + toUnit);
    }

    private double convertFromMillimeter(double value, String toUnit) {
        double result = 0;
        // Implementasi konversi dari mm ke satuan tujuan
        switch (toUnit) {
            case "mm":
                result = value;
                break;
            case "cm":
                result = value / 10;
                break;
            case "dm":
                result = value / 100;
                break;
            case "m":
                result = value / 1000;
                break;
            case "dam":
                result = value / 10000;
                break;
            case "hm":
                result = value / 100000;
                break;
            case "km":
                result = value / 1000000;
                break;
            default:
                result = value ;
                break;
        }
        return result;
    }

    private double convertFromCentimeter(double value, String toUnit) {
        double result = 0;

        // Konversi dari cm ke satuan tujuan
        switch (toUnit) {
            case "mm":
                result = value * 10; // 1 cm = 10 mm
                break;
            case "dm":
                result = value / 10; // 1 cm = 0.1 dm
                break;
            case "m":
                result = value / 100; // 1 cm = 0.01 m
                break;
            case "dam":
                result = value / 1000; // 1 cm = 0.001 dam
                break;
            case "hm":
                result = value / 10000; // 1 cm = 0.0001 hm
                break;
            case "km":
                result = value / 100000; // 1 cm = 0.000001 km
                break;
            default:
                result = value; // Jika satuan tujuan sama dengan sentimeter, hasilnya tetap sama
                break;
        }

        return result;
    }


    private double convertFromDecimeter(double value, String toUnit) {
        double result = 0;

        //konversi dari decimeter ke satuan tujuan

        switch (toUnit){
            case "mm" :
                result = value * 100;
                break;
            case "cm" :
                result = value * 10;
                break;
            case "m" :
                result = value / 10;
                break;
            case "dam" :
                result = value / 100;
                break;
            case "hm" :
                result = value / 1000;
                break;
            case "km" :
                result = value /10000;
                break;
            default:
                result = value;
                break;

        }

        return result;
    }

    private double convertFromMeter(double value, String toUnit) {
        double result = 0 ;

        //konversi dari meter ke satuan tujuan
        switch (toUnit) {
            case "mm":
                result = value * 1000;
                break;
            case "cm" :
                result = value * 100;
                break;
            case "dm" :
                result = value * 10 ;
                break;
            case "dam" :
                result = value / 10 ;
                break;
            case "hm" :
                result = value / 100;
                break;
            case "km" :
                result = value / 1000;
                break;
            default:
                result = value;
                break;
        }

        return result;
    }

    private double convertFromDekameter(double value, String toUnit) {
        double result = 0;

        //konversi dari dekameter ke satuan tujuan
        switch (toUnit) {
            case "mm" :
                result = value * 10000;
                break;
            case "cm" :
                result = value * 1000;
                break;
            case "dm" :
                result = value * 100;
                break;
            case "m" :
                result = value * 10;
                break;
            case "hm" :
                result = value / 1000;
                break;
            case "km" :
                result = value / 100;
                break;
            default :
                result = value;
                break;

        }
        return result ;
    }

    private double convertFromHectometer(double value, String toUnit) {
        double result = 0;

        //konversi dari hektometer ke satuan tujuan

        switch (toUnit) {
            case "mm" :
                result = value * 100000;
                break;
            case "cm" :
                result = value * 10000;
                break;
            case "dm" :
                result = value * 1000;
                break;
            case "m" :
                result = value * 100;
                break;
            case "dam" :
                result = value * 10;
                break;
            case "km" :
                result = value / 10;
                break;
            default:
                result = value;
                break;
        }
        return result;
    }

    private double convertFromKilometer(double value, String toUnit) {
        double result = 0;

        //konversi dari kilometer ke satuan tujuan
        switch (toUnit) {
            case "mm" :
                result = value * 1000000;
                break;
            case "cm" :
                result = value * 100000;
                break;
            case "dm" :
                result = value * 10000;
                break;
            case "m" :
                result = value * 1000;
                break;
            case "dam" :
                result = value * 100;
                break;
            case "hm" :
                result = value * 10;
                break;
            default:
                result = value;
                break;
        }

        return result;
    }
}
