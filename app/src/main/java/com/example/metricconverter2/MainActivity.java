package com.example.metricconverter2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView kg;
    CardView km, temp, time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kg = findViewById(R.id.kg);
        km = findViewById(R.id.km);
        temp = findViewById(R.id.temp);
        time = findViewById(R.id.time);


        //Set On Click Listener to all card view.

        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Mass.class);
                startActivity(intent);
            }
        });

        km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Length.class);
                startActivity(intent);
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Temp.class);
                startActivity(intent);
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TIme.class);
                startActivity(intent);
            }
        });

    }
}