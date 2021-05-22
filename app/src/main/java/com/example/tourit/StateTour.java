package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StateTour extends AppCompatActivity {

    private CardView karnataka, kerala, rajhasthan, maharastra, goa, kashmir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_tour);

        karnataka = findViewById(R.id.karnataka);
        kerala = findViewById(R.id.kerala);
        rajhasthan = findViewById(R.id.ragasthan);
        maharastra = findViewById(R.id.mahasrastra);
        goa = findViewById(R.id.goa);
        kashmir = findViewById(R.id.kashmir);

        karnataka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateTour.this,karnataka.class));

            }
        });

        kerala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rajhasthan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        maharastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        goa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        kashmir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}