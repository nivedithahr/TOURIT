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

public class RidingRafting extends AppCompatActivity {

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
        slideModels.add(new SlideModel("https://imgstaticcontent.lbb.in/lbbnew/wp-content/uploads/sites/2/2016/06/gokarna-kali-f.jpg","Bheemeshwari"));
        slideModels.add(new SlideModel("https://www.karnataka.com/wp-content/uploads/2015/10/white-water-rafting-hidden-woods-srimangala.jpg","Bheemeshwari"));
        slideModels.add(new SlideModel("https://www.karnataka.com/wp-content/uploads/2011/12/bheemeshwari-white-water-rafting.jpg","Bheemeshwari"));
        imageSlider.setImageList(slideModels,true);

        Bh1.setText("About Bheemeshwari : ");
        Bb1.setText("The river Cauvery gathers plenty of force here to give you’re a great rafting experience. But don’t worry about it being scary. There’s a lot of flat grounds to give you less rapid. In fact, you can even hop off the raft for a quick dip in the water. When the monsoon hits, in full glory though, be careful. Rapids go up a notch or so to Grade 3 and can be quite a thrilling affair. You can check into Bheemeshwari Nature and Adventure Camp if you are planning to make it a holiday! \n");
        Bh2.setText("Where to stay:");
        Bb2.setText("•\tGorukana)\n" +
                "•\tZip by Spree Hotels at the Woodrose\n" +
                "•\tGreen Peace Homestay Bheemeshwari\n" +
                "•\tRajathadri Hill Villa\n" +
                "•\tLalitha Mahal Palace Hotel\n");

        nearBangkok = findViewById(R.id.nearBangkok);
        bookBangkok = findViewById(R.id.bookBangkok);

        nearBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RidingRafting.this,NearbyRidingRaft.class));
            }
        });
        bookBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RidingRafting.this,BookBangkok.class));
            }
        });
    }
}