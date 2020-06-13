package com.ananddevelopment.fitness_care;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class exercise extends AppCompatActivity {

Button yoga,cardio,zumba;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);




        AdView down = findViewById(R.id.ads_einfo_bottom);

        AdRequest adRequest = new AdRequest.Builder().build();


        down.loadAd(adRequest);

        yoga = (Button)findViewById(R.id.yoga_btn);
        cardio = (Button)findViewById(R.id.cardio_btn);
        zumba = (Button) findViewById(R.id.zumba_btn);

        Animation move_up_x = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up_x);
        Animation move_up_xx = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up_xx);
        Animation move_up_xxx = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up_xxx);

        Toast.makeText(this, "New Exercise in next update with Steps", Toast.LENGTH_SHORT).show();

        yoga.setAnimation(move_up_x);
        cardio.setAnimation(move_up_xx);
        zumba.setAnimation(move_up_xxx);

        yoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(exercise.this,yoga_exe.class);
                startActivity(i);

            }
        });


        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(exercise.this,cardio_exe.class);
                startActivity(i);
            }
        });


        zumba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(exercise.this,zumba_exe.class);
                startActivity(i);
            }
        });


    }
}
