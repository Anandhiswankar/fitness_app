package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class exercise extends AppCompatActivity {

Button yoga,cardio,zumba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        yoga = (Button)findViewById(R.id.yoga_btn);
        cardio = (Button)findViewById(R.id.cardio_btn);
        zumba = (Button) findViewById(R.id.zumba_btn);


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
