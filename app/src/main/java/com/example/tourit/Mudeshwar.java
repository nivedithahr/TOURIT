package com.example.tourit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Mudeshwar extends AppCompatActivity {

    private TextView Bh1,Bb1,Bh2,Bb2;
    private Button nearBangkok,bookBangkok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangkok);

        ImageSlider imageSlider = findViewById(R.id.bangkokImageSlider);

        Bh1 = findViewById(R.id.Bh1);
        Bb1 = findViewById(R.id.Bb1);
        Bh2 = findViewById(R.id.Bh2);
        Bb2 = findViewById(R.id.Bb2);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://rajeshdeshpande.files.wordpress.com/2017/05/img_7800.jpg?w=821&h=537","Mudeshwar"));
        slideModels.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Murudeshwar_Full_view.jpg/1280px-Murudeshwar_Full_view.jpg","Mudeshwar"));
        slideModels.add(new SlideModel("https://i.redd.it/2hc8j597iw861.jpg","Mudeshwar"));
        imageSlider.setImageList(slideModels,true);

        Bh1.setText("About Mudeshwar: ");
        Bb1.setText("121 Kms from Goa and 500 Kms from Bangalore lies a small coastal town named Murdeshwar.\n" +
                "\n" +
                "Murdeshwar is home to the Shiva temple that is world-renowned for its beautiful carvings and statues. Two life-sized elephants greet visitors at the entrance. While the greenery simply adds to the beauty. It’s no surprise that one could almost mistake Murdeshwar for a fairy tale.\n" +
                "\n" +
                "Bound by the Arabian Sea and the hills of the Western Ghats, the Shiva temple is surrounded by sea on three sides and the surreal sunrise and sunset here are not to be missed. There’s just so much about this enchanted place that people don’t know.");
        Bh2.setText("Where to stay:");
        Bb2.setText("•\tSai Vishram Beach Resort)\n" +
                "•\tRNS Residency\n" +
                "•\tKinara Stay\n" +
                "•\tJyothis Residency\n" +
                "•\tBlue Ocean Sands - On the Beach\n");

        nearBangkok = findViewById(R.id.nearBangkok);
        bookBangkok = findViewById(R.id.bookBangkok);

        nearBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mudeshwar.this,nearbyMudeshwar.class));
            }
        });
        bookBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mudeshwar.this,bookMudeshwar.class));
            }
        });
    }
}