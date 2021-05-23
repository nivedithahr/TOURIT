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

public class ErawanPark extends AppCompatActivity {

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
        slideModels.add(new SlideModel("https://www.thainationalparks.com/img/poi/2013/07/31/7953/erawan-falls-w-900.jpg","Erawan national park"));
        slideModels.add(new SlideModel("https://theculturetrip.com/wp-content/uploads/2017/09/355632006_9e0e0435ea_b-1.jpg","Erawan national park"));
        slideModels.add(new SlideModel("https://i.pinimg.com/originals/67/87/f8/6787f88e8089a1b8aed3fe42d09e8de6.jpg","Erawan national park"));
        imageSlider.setImageList(slideModels,true);

        Bh1.setText("About  Erawan National park:");
        Bb1.setText("Erawan National Park has much to offer to visitors, including a number of caves; paths that cut through thick deciduous forests; and fauna that includes wild elephants, gibbons, and great hornbills. But it's the waterfalls here—and especially the seven-tiered Erawan Falls—that attract the bulk of the visitors.\n" +
                "The falls are named after the white elephant that travels with the Hindu god Indra because the tiers are said to slightly resemble the shape of an elephant's head.\n" +
                "Each of the seven tiers also has its own name, and reaching them gets harder and harder as you go up—after the fifth tier, visitors need to use slippery ladders while pushing through thick vegetation in order to continue. You might not need to venture that far, though. The first three tiers are actually the most impressive, offering emerald green pools, a small cave, and cool cascading waters. Plenty of curious fish live in the pools, so don't be surprised to feel them swimming between your feet.\n");
        Bh2.setText("Where to stay:");
        Bb2.setText("•\tThe FloatHouse River Kwai I Floating Villas\n" +
                "•\tBaanpufa Resort\n" +
                "•\tThe Hub Erawan Resort\n" +
                "•\tAnantha River Hill Resort\n" +
                "•\tZ9 Resort\n");

        nearBangkok = findViewById(R.id.nearBangkok);
        bookBangkok = findViewById(R.id.bookBangkok);

        nearBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ErawanPark.this,NearErawanPark.class));
            }
        });
        bookBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ErawanPark.this,bookErawanPark.class));
            }
        });
    }
}