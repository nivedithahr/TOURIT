package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorldTour extends AppCompatActivity {

    private CardView usa, german, aus, dubai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_tour);

        usa  = findViewById(R.id.thailand);
        german = findViewById(R.id.german);
        aus = findViewById(R.id.aus);
        dubai = findViewById(R.id.dubai);

        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorldTour.this,Thailand.class));
            }
        });

        german.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent german
            }
        });

        aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent aus
            }
        });

        dubai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent dubai
            }
        });
    }
}