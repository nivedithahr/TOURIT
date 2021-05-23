package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StateTour extends AppCompatActivity {

    private CardView karnataka, kerala, rajhasthan, maharastra, goa, kashmir;
    TextView title;
    ImageView chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_tour);

        getSupportActionBar().hide();

        karnataka = findViewById(R.id.karnataka);
        kerala = findViewById(R.id.kerala);
        rajhasthan = findViewById(R.id.ragasthan);
        maharastra = findViewById(R.id.mahasrastra);
        goa = findViewById(R.id.goa);
        kashmir = findViewById(R.id.kashmir);

        title = findViewById(R.id.Title);
        title.setText("State Tour");
        chat = findViewById(R.id.chatTop);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateTour.this,OfficialGroup.class));
            }
        });

        karnataka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StateTour.this,Category.class));

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