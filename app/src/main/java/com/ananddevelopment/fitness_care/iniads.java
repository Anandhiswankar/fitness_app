package com.ananddevelopment.fitness_care;

import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class iniads {

    InterstitialAd ads;

    public void initads(Context con)
    {
        MobileAds.initialize(con, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        adsid a = new adsid();

        ads = new InterstitialAd(con);
        ads.setAdUnitId(a.fullscreenads);

        ads.loadAd(new AdRequest.Builder().build());




    }




    public void showads(Context con)
    {
        if(ads.isLoaded())
        {
            ads.show();
        }
        else
        {
           this.initads(con);
        }
    }


}
