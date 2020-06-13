package com.ananddevelopment.fitness_care;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class zumba_exe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zumba_exe);


        AdView top = findViewById(R.id.ads_zumba_top);
        AdView down = findViewById(R.id.ads_zumba_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();

        top.loadAd(adRequest);
        down.loadAd(adRequest);

    }
}
