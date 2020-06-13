package com.ananddevelopment.fitness_care;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class policy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        AdView top = findViewById(R.id.ads_policy_top);
        AdView down = findViewById(R.id.ads_policy_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();

        top.loadAd(adRequest);
        down.loadAd(adRequest);
    }
}
