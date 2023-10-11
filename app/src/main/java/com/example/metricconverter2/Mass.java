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


public class Mass extends AppCompatActivity {

    private EditText editTextMass;
    private Spinner spinnerFromUnit, spinnerToUnit;
    private Button buttonConvert;
    private TextView textViewResult;
    public ImageView length, temp, time ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);

        editTextMass = findViewById(R.id.editTextMass);
        spinnerFromUnit = findViewById(R.id.spinnerFromUnit);
        spinnerToUnit = findViewById(R.id.spinnerToUnit);
        buttonConvert = findViewById(R.id.buttonConvert);
        textViewResult = findViewById(R.id.textViewResult);

        length = findViewById(R.id.length);
        temp = findViewById(R.id.temp);
        time = findViewById(R.id.time);

        // Mengisi spinner dengan daftar satuan panjang
        String[] MassUnits = {"mg", "cg", "dg", "g", "dag", "hg", "kg"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, MassUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFromUnit.setAdapter(adapter);
        spinnerToUnit.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertMass();
            }
        });

        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mass.this,Length.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mass.this,Temp.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mass.this,TIme.class);
                startActivity(intent);
            }
        });


    }

    private void convertMass() {
        double inputValue = Double.parseDouble(editTextMass.getText().toString());
        String fromUnit = spinnerFromUnit.getSelectedItem().toString();
        String toUnit = spinnerToUnit.getSelectedItem().toString();
        double result = 0;

        // Konversi satuan massa sesuai dengan satuan awal dan satuan tujuan yang dipilih
        switch (fromUnit) {
            case "mg":
                result = convertFromMilligram(inputValue, toUnit);
                break;
            case "cg":
                result = convertFromCentigram(inputValue, toUnit);
                break;
            case "dg":
                result = convertFromDecigram(inputValue, toUnit);
                break;
            case "g":
                result = convertFromGram(inputValue, toUnit);
                break;
            case "dag":
                result = convertFromDekagram(inputValue, toUnit);
                break;
            case "hg":
                result = convertFromHectogram(inputValue, toUnit);
                break;
            case "kg":
                result = convertFromKilogram(inputValue, toUnit);
                break;
        }

        textViewResult.setText("Result: " + result + " " + toUnit);
    }

    private double convertFromMilligram(double value, String toUnit) {
        double result = 0;
        // Implementasi konversi dari mm ke satuan tujuan
        switch (toUnit) {
            case "mg":
                result = value;
                break;
            case "cg":
                result = value / 10;
                break;
            case "dg":
                result = value / 100;
                break;
            case "g":
                result = value / 1000;
                break;
            case "dag":
                result = value / 10000;
                break;
            case "hg":
                result = value / 100000;
                break;
            case "kg":
                result = value / 1000000;
                break;
        }
        return result;
    }

    private double convertFromCentigram(double value, String toUnit) {
        double result = 0;

        // Konversi dari cm ke satuan tujuan
        switch (toUnit) {
            case "mg":
                result = value * 10; // 1 cm = 10 mm
                break;
            case "dg":
                result = value / 10; // 1 cm = 0.1 dm
                break;
            case "g":
                result = value / 100; // 1 cm = 0.01 m
                break;
            case "dag":
                result = value / 1000; // 1 cm = 0.001 dam
                break;
            case "hg":
                result = value / 10000; // 1 cm = 0.0001 hm
                break;
            case "kg":
                result = value / 100000; // 1 cm = 0.000001 km
                break;
            default:
                result = value; // Jika satuan tujuan sama dengan sentimeter, hasilnya tetap sama
                break;
        }

        return result;
    }


    private double convertFromDecigram(double value, String toUnit) {
        double result = 0;

        //konversi dari decimeter ke satuan tujuan

        switch (toUnit){
            case "mg" :
                result = value * 100;
                break;
            case "cg" :
                result = value * 10;
                break;
            case "g" :
                result = value / 10;
                break;
            case "dag" :
                result = value / 100;
                break;
            case "hg" :
                result = value / 1000;
                break;
            case "kg" :
                result = value /10000;
                break;
            default:
                result = value;
                break;

        }

        return result;
    }

    private double convertFromGram(double value, String toUnit) {
        double result = 0 ;

        //konversi dari meter ke satuan tujuan
        switch (toUnit) {
            case "mg":
                result = value * 1000;
                break;
            case "cg" :
                result = value * 100;
                break;
            case "dg" :
                result = value * 10 ;
                break;
            case "dag" :
                result = value / 10 ;
                break;
            case "hg" :
                result = value / 100;
                break;
            case "kg" :
                result = value / 1000;
                break;
            default:
                result = value;
                break;
        }

        return result;
    }

    private double convertFromDekagram(double value, String toUnit) {
        double result = 0;

        //konversi dari dekameter ke satuan tujuan
        switch (toUnit) {
            case "mg" :
                result = value * 10000;
                break;
            case "cg" :
                result = value * 1000;
                break;
            case "dg" :
                result = value * 100;
                break;
            case "g" :
                result = value * 10;
                break;
            case "hg" :
                result = value / 1000;
                break;
            case "kg" :
                result = value / 100;
                break;
            default :
                result = value;
                break;

        }
        return result ;
    }

    private double convertFromHectogram(double value, String toUnit) {
        double result = 0;

        //konversi dari hektometer ke satuan tujuan

        switch (toUnit) {
            case "mg" :
                result = value * 100000;
                break;
            case "cg" :
                result = value * 10000;
                break;
            case "dg" :
                result = value * 1000;
                break;
            case "g" :
                result = value * 100;
                break;
            case "dag" :
                result = value * 10;
                break;
            case "kg" :
                result = value / 10;
                break;
            default:
                result = value;
                break;
        }
        return result;
    }

    private double convertFromKilogram(double value, String toUnit) {
        double result = 0;

        //konversi dari kilometer ke satuan tujuan
        switch (toUnit) {
            case "mg" :
                result = value * 1000000;
                break;
            case "cg" :
                result = value * 100000;
                break;
            case "dg" :
                result = value * 10000;
                break;
            case "g" :
                result = value * 1000;
                break;
            case "dag" :
                result = value * 100;
                break;
            case "hg" :
                result = value * 10;
                break;
            default:
                result = value;
                break;
        }

        return result;
    }











}
