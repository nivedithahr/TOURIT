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

public class coorg extends AppCompatActivity {

    private TextView h1, b1,h2,sh1,b3,sh2,b4,sh3,b5,h3,b6,h5,b7,h6,b8,h7,b9;

    private Button nearCoorg,coorgBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coorg);

        nearCoorg = findViewById(R.id.nearCoorg);
        coorgBook = findViewById(R.id.coorgBook);

        ImageSlider imageSlider = findViewById(R.id.coorgImageSlider);

        h1 = findViewById(R.id.h1);
        b1 = findViewById(R.id.b1);
        h2 = findViewById(R.id.h2);
        sh1 = findViewById(R.id.sh1);
        b3 = findViewById(R.id.b3);
        sh2 = findViewById(R.id.sh2);
        b4 = findViewById(R.id.b4);
        sh3 = findViewById(R.id.sh3);
        b5 = findViewById(R.id.b5);
        h3 = findViewById(R.id.h3);
        b6 = findViewById(R.id.b6);
        h5 = findViewById(R.id.h5);
        b7 = findViewById(R.id.b7);
        h6 = findViewById(R.id.h6);
        b8 = findViewById(R.id.b8);
        h7 = findViewById(R.id.h7);
        b9 = findViewById(R.id.b9);



        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://revolvingcompass.com/wp/wp-content/uploads/2017/03/AbbeyFalls-min.jpg","Abbey Falls"));
        slideModels.add(new SlideModel("https://live.staticflickr.com/3028/3001596738_dcba0550fe_b.jpg","Abbey Falls"));
        slideModels.add(new SlideModel("https://live.staticflickr.com/2412/2239123397_8355a0ac41_b.jpg","Abbey Falls"));
        imageSlider.setImageList(slideModels,true);

        h1.setText("Essential information to know about Abbey Falls:");
        b1.setText("->Location: \n\nAbbey Falls is located in the Coorg region of Western Ghats in Karnataka. It is situated at a distance of 10 kilometres from Madikeri and about 122 km away from Mysore. From Bangalore, Abbey Falls is 268 km away. Situated amidst a landscape of coffee and spice plantations, Abbey Falls is one of the prominent tourist attractions around Coorg. After taking a walk for around 200 steps, tourists can reach Abbey Falls.\n\n" +
                "->Timings:  \n\nOne can visit Abbey Falls on any day of the week as it remains open for all seven days. The timing for visiting the waterfalls in from 9 am to 5 pm.\n\n" +
                "->Entry Fee: \n\nThe tourists can get entry to Abbey Falls by paying an amount of INR 15 per person.\n\n" +
                "->Height: \n\nCascading from a height of 70 feet, Abbey Falls is a sight to behold in Coorg. It is encompassed by lush greenery and offers a spectacular view that will not let your attention hinder. After many streams combine, the waterfalls forms and flow together to join River Kaveri on the land. The flow of the waterfall increases during the time of monsoon.\n");

        h2.setText("How to Reach Abbey Falls:");
        sh1.setText("- By Road");
        b3.setText("If you are coming via Madikeri, you need to go through Galibeedu road to reach the falls and then walk for a while. If coming via Mangalore, Mysore or Bangalore, cabs or taxis are easily available for hire.");
        sh2.setText("- By Rail");
        b4.setText("The nearest railway station to Abbey Falls is Mysore Railway stations. From there one needs to take a cab or hire a taxi to reach directly to Abbey Falls or go via bus up to Madikeri and then take local transport to reach Abbey Falls.");
        sh3.setText("- By Bus");
        b5.setText("There are many regular KSRTC buses which one can find running from Bangalore, Mysore, and Mangalore to reach Madikeri which is the closest town to Abbey Falls.");
        h3.setText("Things To Do at Abbey Falls:");
        b6.setText("1.\tCherish the breath-taking natural beauty:\n" +
                "2.\tTour of coffee and cardamom plantations:\n" +
                "3.\tTrekking\n" +
                "4.\tPhotography\n");
        h5.setText("Tips For Visiting Abbey Falls:");
        b7.setText("1.\tOne should check with the local driver about the water availability and crowd density at the waterfalls if you wish to know in advance for having lesser crowds and an enthralling water flow during your vacation.\n" +
                "2.\tTourists are advised to carry water and food as there are not many places where along the way to the falls and the walk can be excruciating. One can find places to eat at the stalls near the parking lot.\n" +
                "3.\tHave an eye for leeches as they are very common in the wet forests. You should carry salt in case you get stuck by a leech. One should wear closed shoes and exercise caution while going for a walk. Also, if you are going during monsoons it is necessary that you look out for slippery steps.\n" +
                "4.\tKeep your medical aid handy when you are climbing the stairs as there could be an instance where you suffer from breathing issues. It should also be noted that bathing in the waterfalls is not allowed for various safety reasons.\n");
        h6.setText("Other places to visit near abbey falls:");
        b8.setText("1. Nagarhole National Park\n" +
                "2. Omkareshwara Temple\n" +
                "3. Raja’s Seat\n" +
                "4) Irpu Falls\n" +
                "5) Raja’s Tomb\n" +
                "6) Namdroling Monastery\n" +
                "7) Madikeri Fort\n" +
                "8) Galibeedu Trek\n" +
                "9) Chingara Falls\n");
        h7.setText("Places to stay near abbey falls:");
        b9.setText("1) Palm Era Resorts\n" +
                "2) Green Vista Homestay\n" +
                "3) Heritage Resort Coorg\n" +
                "4) Down's Retreat, A Golf Resort\n" +
                "5) Maxima Resort\n" +
                "6) Club Mahindra Madikeri Resort and Spa\n");


        nearCoorg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(coorg.this,NearbyCoorg.class));
            }
        });

        coorgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(coorg.this,coorgbookguide.class));
            }
        });

    }
}