package com.ananddevelopment.fitness_care;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class diet_Plans extends AppCompatActivity {

    AdView top,down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet__plans);

        top = findViewById(R.id.ads_wl_top);
        down = findViewById(R.id.ads_wl_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();

        top.loadAd(adRequest);
        down.loadAd(adRequest);



    }
}
