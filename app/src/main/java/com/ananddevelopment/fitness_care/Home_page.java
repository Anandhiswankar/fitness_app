package com.ananddevelopment.fitness_care;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Home_page extends AppCompatActivity {
    ImageView ivWork,ivexercise,ivAbout,ivRemind,ivDiet;
    DataBaseHelper dbh;

    private AdView about_panel_bottom_ads;
    private InterstitialAd interstitialAd_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });



        about_panel_bottom_ads = findViewById(R.id.home_page_ads);
        AdRequest adRequest = new AdRequest.Builder().build();
        about_panel_bottom_ads.loadAd(adRequest);





        ivWork = findViewById(R.id.ivWork);
        ivexercise = findViewById(R.id.ivexercise);
        ivAbout = findViewById(R.id.ivAbout);
        ivRemind = findViewById(R.id.ivRemind);
        ivDiet = findViewById(R.id.ivDiet);

        Animation right_to_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left_anim);
        Animation right_to_left_speed_x = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left_speed_x);
        Animation right_to_left_speed_xx = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left_speed_xx);
        Animation right_to_left_speed_xxx = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left_speed_xxx);
        Animation right_to_left_speed_4x = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left_speed_4x);


        ivWork.setAnimation(right_to_left);
        ivexercise.setAnimation(right_to_left_speed_x);
        ivRemind.setAnimation(right_to_left_speed_xx);
        ivDiet.setAnimation(right_to_left_speed_xxx);
        ivAbout.setAnimation(right_to_left_speed_4x);

        ivWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {



                    Intent intent = new Intent(Home_page.this, workout.class);
                    startActivity(intent);


                } catch (Exception err) {
                    err.printStackTrace();
                }

            }
        });
        ivexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Home_page.this, exercise.class);
                startActivity(intent);



            }
        });
        ivRemind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(Home_page.this, reminder.class);
                startActivity(intent);
            }
        });
        ivDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home_page.this, diet.class);
                startActivity(intent);
            }
        });
        ivAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(Home_page.this,about.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Are you sure you want to Quit?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Home_page.super.onBackPressed();

            }
        })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        dialog.cancel();
                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
}
