package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShoeExcursion extends AppCompatActivity {

    private Button coorgDetails,coorgDetails1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karnataka);

        coorgDetails = findViewById(R.id.coorgDetails);

        coorgDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShoeExcursion.this,Mudeshwar.class));
            }
        });



    }
}