package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {

    private Button Ksiding,Ksea,Kad,funriding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Ksiding = findViewById(R.id.Ksiding);
        Ksea = findViewById(R.id.sea);
        Kad = findViewById(R.id.Kad);
        funriding = findViewById(R.id.funriding);

        Ksiding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Category.this,karnataka.class));
            }
        });

        Ksea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(Category.this,Sea.class));
            }
        });
        Kad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Category.this,advantureKa.class));
            }
        });

        funriding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Category.this,Funriding.class));
            }
        });


    }
}