package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Thailand extends AppCompatActivity {

    private Button bangkokDetails1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thailand);

        bangkokDetails1 = findViewById(R.id.bangkokDetails1);



        bangkokDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Thailand.this,Bangkok.class));
            }
        });
    }
}