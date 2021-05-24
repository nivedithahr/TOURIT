
package com.example.tourit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    private Button worldTour, stateTour;

    private FloatingActionButton floatBtn;

    private LinearLayout share;

    private TextView nameView,emailView,View;


    private FirebaseUser currentUser;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = currentUser.getUid();
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserObject userObject = snapshot.getValue(UserObject.class);

                if (userObject != null){
                    String name = userObject.userName;
                    String email = userObject.userEmail;

                    nameView.setText(name);
                    emailView.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        nameView = findViewById(R.id.nameView);
        emailView = findViewById(R.id.emailView);

        drawerLayout = findViewById(R.id.drawer_layout);

        worldTour = findViewById(R.id.worldTour);
        stateTour = findViewById(R.id.stateTour);

        share = findViewById(R.id.share);

        floatBtn = findViewById(R.id.folatBtn);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                startActivity(new Intent(MainActivity.this,OfficialGroup.class));
            }
        });



        worldTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,WorldTour.class));
            }
        });

        stateTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,StateTour.class));
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String body = "Download this App";
                String sub = "http://play.google.com";
                intent.putExtra(Intent.EXTRA_TEXT,body);
                intent.putExtra(Intent.EXTRA_TEXT,sub);
                startActivity(Intent.createChooser(intent,"Share Using"));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (currentUser == null){
            startActivity(new Intent(MainActivity.this,Login.class));
            finish();
        }

    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closerDrawer(drawerLayout);
    }

    private static void closerDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickAbout(View view){

        redirectActivity(this,About.class);
    }

    public void ClickRate(View view){

        redirectActivity(this,RateUs.class);
    }
    public void ClickPrivacy(View view){

        redirectActivity(this,Privacy.class);
    }

    public void ClickLogout(View view){

        Logout(this,Login.class);
    }

    private static void Logout(Activity activity,Class aclass) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("logout");
        builder.setMessage("Are you sure to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(activity,aclass);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


    private static void redirectActivity(Activity activity,Class aclass) {
        Intent intent = new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closerDrawer(drawerLayout);
    }


}