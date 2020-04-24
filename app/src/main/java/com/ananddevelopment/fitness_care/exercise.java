package com.ananddevelopment.fitness_care;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class exercise extends AppCompatActivity {
    ImageView ivexercise1,ivexercise2,ivexercise3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        ivexercise1=findViewById(R.id.ivexercise1);
        ivexercise2=findViewById(R.id.ivexercise2);
        ivexercise3=findViewById(R.id.ivexercise3);

    }
}
