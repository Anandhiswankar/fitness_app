package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_page extends AppCompatActivity {
    ImageView ivWork,ivexercise,ivAbout,ivRemind,ivDiet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ivWork=findViewById(R.id.ivWork);
        ivexercise=findViewById(R.id.ivexercise);
        ivAbout=findViewById(R.id.ivAbout);
        ivRemind=findViewById(R.id.ivRemind);
        ivDiet=findViewById(R.id.ivDiet);

        ivWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent=new Intent(Home_page.this,workout.class);
                    startActivity(intent);
                }
                catch (Exception err)
                {
                    err.printStackTrace();
                }

            }
        });
        ivexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(Home_page.this,exercise.class);
                //startActivity(intent);
            }
        });
        ivRemind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(Home_page.this,reminder.class);
                //startActivity(intent);
            }
        });
        ivDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent=new Intent(Home_page.this,diet.class);
                //startActivity(intent);
            }
        });ivAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(Home_page.this,about.class);
                //startActivity(intent);
            }
        });





    }


    public void onBackPressed()
    {
        finish();
        super.onBackPressed();
    }



}
