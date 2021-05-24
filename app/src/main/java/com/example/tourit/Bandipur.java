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

public class Bandipur extends AppCompatActivity {
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
        slideModels.add(new SlideModel("https://zone-trt-bhxtb9xxzrrdpzhqr.netdna-ssl.com/wp-content/uploads/2016/08/The-Grand-Palace-bangkok1-860x574.jpg","The Grand Place-Bangkok"));
        slideModels.add(new SlideModel("https://sites.google.com/site/top12thailandattractions/_/rsrc/1479703534807/1-bangkok-2/1-1-grand-palace-wat-prakeaw-old-city/bangkok-grand-palace.jpg","The Grand Place-Bangkok"));
        slideModels.add(new SlideModel("https://www.trawell.in/admin/images/upload/161646913Grand_Palace.jpg","The Grand Place-Bangkok"));
        imageSlider.setImageList(slideModels,true);

        Bh1.setText("About grand palace: ");
        Bb1.setText("Even if your plans for Thailand mainly involve frolicking on a beach and eating as much Massaman curry and pad Thai as humanly possible, you'll probably spend at least a day or two in Bangkok. There are plenty of things to see and do in the capital, but the Grand Palace should definitely be at the top of your list. This is the number one sightseeing attraction in the city, and it's staggering in both historical significance and craftsmanship.\n" +
                "The grounds are a maze of royal halls, temples, and ancient relics, the most important being Wat Phra Kaeo (the Temple of the Emerald Buddha), said to hold a fragment of either hair or bone from the enlightened Buddha himself.\n" +
                "Allow several hours to do the Grand Palace justice, but if you're up for more walking afterward, you can easily take in some of the city's other major landmarks nearby. The famous Wat Po and Wat Arun, the Temple of the Dawn (a great place to watch the sunset), are just a few minutes away.\n");
        Bh2.setText("Where to stay:");
        Bb2.setText("•\tRiva Arun Bangkok(0.7 kilometer to Grand Palace)\n" +
                "•\tSala rattanakosin(0.6 kilometer to Grand Palace)\n" +
                "•\tAurum The River Place(0.8 kilometer to Grand Palace)\n" +
                "•\tBaan Wanglang Riverside(0.7 kilometer to Grand Palace)\n" +
                "•\tSiri Heritage Bangkok Hotel(0.6 kilometer to Grand Palace)\n");

        nearBangkok = findViewById(R.id.nearBangkok);
        bookBangkok = findViewById(R.id.bookBangkok);

        nearBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Bandipur.this,NearbyBangkok.class));
            }
        });
        bookBangkok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Bandipur.this,BookBangkok.class));
            }
        });
    }
}