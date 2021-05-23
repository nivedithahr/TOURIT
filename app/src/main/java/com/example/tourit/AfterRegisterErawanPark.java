package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterRegisterErawanPark extends AppCompatActivity{

        private TextView regNameView,regPhoneView,regPeopleView,regDaysView,regRestaurantView,regDateView,totalCost,regTimeView,guideName,guideEmail,guideMob;
        private Button returnHome;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_after_register);

            regNameView = findViewById(R.id.regNameView);
            regPhoneView = findViewById(R.id.regPhoneView);
            regPeopleView = findViewById(R.id.regPeopleView);
            regDaysView = findViewById(R.id.regDaysView);
            regRestaurantView = findViewById(R.id.regResturantView);
            regDateView = findViewById(R.id.regDateView);
            totalCost = findViewById(R.id.totalCost);
            returnHome = findViewById(R.id.returnHome);
            regTimeView = findViewById(R.id.regTimeView);
            guideName = findViewById(R.id.guideName);
            guideEmail = findViewById(R.id.guideEmail);
            guideMob = findViewById(R.id.guideMob);

            guideName.setText("Niveditha");
            guideEmail.setText("nivedithah@gmail.com");
            guideMob.setText("+91 976543210");

            String name = getIntent().getStringExtra("name");
            String phone = getIntent().getStringExtra("phone");
            String people = getIntent().getStringExtra("people");
            String days = getIntent().getStringExtra("days");
            String restaurant = getIntent().getStringExtra("restaurant");
            String date = getIntent().getStringExtra("date");
            String time = getIntent().getStringExtra("time");

            double a,b,r;

            a = Double.parseDouble(people);
            b = Double.parseDouble(days);

            r = a * b * 22000;

            String result = Double.toString(r);

            regNameView.setText(name);
            regPhoneView.setText(phone);
            regPeopleView.setText(people);
            regDaysView.setText(days);
            regRestaurantView.setText(restaurant);
            regDateView.setText(date);
            regTimeView.setText(time);
            totalCost.setText(result);

            returnHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AfterRegisterErawanPark.this,MainActivity.class));
                }
            });

        }
}