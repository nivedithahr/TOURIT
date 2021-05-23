package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {

    private TextView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        about = findViewById(R.id.about);

        about.setText("Travel is the main thing you purchase that makes you more extravagant”. We, at ‘TourIt, swear by this and put stock in satisfying travel dreams that make you perpetually rich constantly. We have been moving excellent encounters for a considerable length of time through our cutting edge planned occasion bundles and other fundamental travel administrations. We rouse our clients to carry on with a rich life, brimming with extraordinary travel encounters.\n\n" +
                "User can book for guide for the place or Country user wants to visit. Our guide details will be shared to user once they book guide for their respective places. Our guide takes full responsivity to make sure that User can have a healthy and happy touring. Booking of a guide covers all necessary things such as – \tPickup and drop user from their nearby Places, \tbooking hotels, \tarranging cars to visit each and every places user booked for and \twe provide meal also in our guide package.\n");
    }
}