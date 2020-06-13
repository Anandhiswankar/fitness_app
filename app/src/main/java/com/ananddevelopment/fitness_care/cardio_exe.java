package com.ananddevelopment.fitness_care;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class cardio_exe extends AppCompatActivity {

    private AdView topads,downads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_exe);

        topads = findViewById(R.id.ads_cardio_top);
        downads = findViewById(R.id.ads_cardio_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();


        topads.loadAd(adRequest);
        downads.loadAd(adRequest);


    }
}
