package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class about extends AppCompatActivity {

    TextView policy,tandc,a1,a2,a3,a4,a5,a6,a7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Animation pop = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop_up);

        policy = findViewById(R.id.policy);
        tandc  = findViewById(R.id.tandc);

        a1= findViewById(R.id.textView22);
        a2= findViewById(R.id.textView32);
        a3= findViewById(R.id.textView33);
        a4= findViewById(R.id.textView34);
        a5= findViewById(R.id.textView35);
        a6= findViewById(R.id.textView36);
        a7= findViewById(R.id.textView37);

        a1.setAnimation(pop);
        a2.setAnimation(pop);
        a3.setAnimation(pop);
        a4.setAnimation(pop);
        a5.setAnimation(pop);
        a6.setAnimation(pop);
        a7.setAnimation(pop);
        policy.setAnimation(pop);
        tandc.setAnimation(pop);

        policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(about.this,policy.class);
                startActivity(i);
            }
        });

        tandc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(about.this,TandC.class);
                startActivity(i);
            }
        });

    }
}
