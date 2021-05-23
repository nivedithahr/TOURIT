package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Privacy extends AppCompatActivity {

    TextView ph1,pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        ph1 = findViewById(R.id.ph1);
        pb1 = findViewById(R.id.pb1);

        ph1.setText("Privacy Policy");

        pb1.setText("TourIt is committed to protecting your Personal Information that you share with us. Please take a moment to review this Privacy Policy (referred to as “Policy”) where you can find more details about how we collect and process your information. By using our app or the services offered by us, you are consenting to our use of such personal information as you provide to us as described herein. If you do not consent to our use of your information, please do not use our services. \n" +
                "\n\n" +
                "We need to collect, use and disclose personal information in order to perform our business functions and activities, including making and managing travel bookings on behalf of our customers. We are firmly committed to protecting the privacy and confidentiality of personal information with various physical, electronic and procedural safeguards. For the purposes of the General Data Protection Regulation (“GDPR”) we assume a role of either the “data processor” or “data controller” for any personal information you provide to us in connection with our relationship. The exact role assumed depends on the context of our relationship with you and the purpose of the processing of personal information.\n");
    }
}