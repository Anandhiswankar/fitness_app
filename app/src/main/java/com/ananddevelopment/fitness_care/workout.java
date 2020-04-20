package com.ananddevelopment.fitness_care;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

public class workout extends AppCompatActivity {


    Button add_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        add_note = (Button) findViewById(R.id.goto_add_note);


        add_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(workout.this,add_note.class);
                startActivity(intent);

            }
        });



    }



}