package com.ananddevelopment.fitness_care;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class TandC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tand_c);


        AdView top = findViewById(R.id.ads_tandc_top);
        AdView down = findViewById(R.id.ads_tandc_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();

        top.loadAd(adRequest);
        down.loadAd(adRequest);

    }
}
