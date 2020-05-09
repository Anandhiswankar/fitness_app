package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class reminder extends AppCompatActivity {
    TextView ivTask1;
    ImageView rem1,rem2,rem3,rem4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        rem1=findViewById(R.id.rem1);
        rem2=findViewById(R.id.rem2);
        rem3=findViewById(R.id.rem3);
        rem4=findViewById(R.id.rem4);




        rem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reminder.this,rem1.class);
                startActivity(intent);
            }
        });

        rem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reminder.this,rem2.class);
                startActivity(intent);
            }
        });

        rem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reminder.this,rem3.class);
                startActivity(intent);
            }
        });

        rem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reminder.this,rem4.class);
                startActivity(intent);
            }
        });


    }
}
