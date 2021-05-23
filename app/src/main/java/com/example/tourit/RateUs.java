package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RateUs extends AppCompatActivity {

    TextView ratingText;
    RatingBar ratingBar;
    EditText feedbackText;
    Button feedbackBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);
        feedbackText = findViewById(R.id.feedbackText);
        feedbackBtn = findViewById(R.id.feedbackBtn);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (rating == 1){
                    ratingText.setText("Poor 🙁");
                }else if (rating == 2){
                    ratingText.setText("Not Bad 🙂");
                }else if (rating == 3){
                    ratingText.setText("Good 😊");
                }else if (rating == 4){
                    ratingText.setText("Very Good 😊");
                }else{
                    ratingText.setText("Excellent 🤩");
                }
            }
        });

        feedbackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateUs.this, "Thank You for providing your Feedback", Toast.LENGTH_SHORT).show();
                feedbackText.setText("");
                startActivity(new Intent(RateUs.this,MainActivity.class));
            }
        });
    }
}