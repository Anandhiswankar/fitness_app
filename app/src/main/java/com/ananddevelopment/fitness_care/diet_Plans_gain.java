package com.ananddevelopment.fitness_care;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class diet_Plans_gain extends AppCompatActivity {

    AdView top,down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plain_gain);


        top = findViewById(R.id.ads_wg_top);
        down = findViewById(R.id.ads_wg_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();

        top.loadAd(adRequest);
        down.loadAd(adRequest);

    }
}
