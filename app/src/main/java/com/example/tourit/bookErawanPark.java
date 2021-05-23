package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class bookErawanPark extends AppCompatActivity {

    private EditText regName,regPhone,regPeople,regDays;
    private TextView regDate,regTime,price;
    private AutoCompleteTextView regResturant;
    private ProgressBar regProgress;
    private ImageView drp;
    private Button submit;

    private FirebaseAuth userAuth;
    private FirebaseDatabase database;

    int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coorgbookguide);

        price = findViewById(R.id.price);
        price.setText("Rs.22,000/-");

        regName = findViewById(R.id.regName);
        regPhone = findViewById(R.id.regPhone);
        regPeople = findViewById(R.id.regPeople);
        regDays = findViewById(R.id.regDayes);
        regDate = findViewById(R.id.regdate);
        Calendar calendar = Calendar.getInstance();
        regDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(bookErawanPark.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        regDate.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        regTime = findViewById(R.id.regTime);
        regTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(bookErawanPark.this, R.style.Theme_AppCompat, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        SimpleDateFormat format = new SimpleDateFormat("k:mm a");
                        String time = format.format(c.getTime());
                        regTime.setText(time);
                    }
                },hour,min,false);
                timePickerDialog.show();
            }
        });

        drp = findViewById(R.id.drp1);

        regResturant = findViewById(R.id.regResturant);

        regProgress = findViewById(R.id.regProgress);

        userAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        submit = findViewById(R.id.submit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,resturant);
        regResturant.setAdapter(adapter);
        drp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                regResturant.showDropDown();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

    }

    private void submitForm() {
        String uId = userAuth.getCurrentUser().getUid();
        String name = regName.getText().toString().trim();
        String phone = regPhone.getText().toString().trim();
        String people = regPeople.getText().toString().trim();
        String days = regDays.getText().toString().trim();
        String restaurant = regResturant.getText().toString().trim();
        String date = regDate.getText().toString().trim();
        String time = regTime.getText().toString().trim();

        if (name.isEmpty() || phone.isEmpty() || people.isEmpty() || days.isEmpty() || restaurant.isEmpty() || date.isEmpty()){
            Toast.makeText(this, "Fill the Complete Form", Toast.LENGTH_LONG).show();
        }
        else {

            Intent intent = new Intent(bookErawanPark.this,AfterRegisterErawanPark.class);
            intent.putExtra("name",name);
            intent.putExtra("phone",phone);
            intent.putExtra("people",people);
            intent.putExtra("days",days);
            intent.putExtra("restaurant",restaurant);
            intent.putExtra("date",date);
            intent.putExtra("time",time);
            startActivity(intent);

        }
    }



    private static String[] resturant = new String[]{"The FloatHouse River Kwai I Floating Villas",
            "Baanpufa Resort","" +
            "The Hub Erawan Resort",
            "Anantha River Hill Resort",
            "Z9 Resort"};
}