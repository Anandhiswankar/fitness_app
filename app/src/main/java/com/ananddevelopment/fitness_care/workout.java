package com.ananddevelopment.fitness_care;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.ImageView;

public class workout extends AppCompatActivity {


    Button add_note,my_health;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Animation pop_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop_up);



        add_note = (Button) findViewById(R.id.goto_add_note);

        my_health = (Button) findViewById(R.id.My_health_btn);


        add_note.setAnimation(pop_up);
        my_health.setAnimation(pop_up);


        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(workout.this,add_note.class);
                startActivity(intent);

            }
        });

        my_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(workout.this,my_profile.class);
                startActivity(intent);
            }
        });




    }



}