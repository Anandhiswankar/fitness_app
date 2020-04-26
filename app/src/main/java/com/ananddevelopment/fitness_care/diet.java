package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class diet extends AppCompatActivity {

    Button btnGain,btnlose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        btnlose=findViewById(R.id.btnlose);

        btnGain=findViewById(R.id.btnGain);

        btnlose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(diet.this,diet_Plans.class);
                startActivity(intent);
            }
        });

        btnGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(diet.this,diet_Plans_gain.class);
                startActivity(intent);
            }
        });
    }
}
