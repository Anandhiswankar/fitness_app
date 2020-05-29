package com.ananddevelopment.fitness_care;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class diet extends AppCompatActivity {

    Button btnGain,btnlose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        btnlose=findViewById(R.id.btnlose);
        btnGain=findViewById(R.id.btnGain);
        Animation pop_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop_up);

        btnlose.setAnimation(pop_up);
        btnGain.setAnimation(pop_up);
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
        customDialog();
    }

    public  void  customDialog()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this,R.style.ThemeOverlay_AppCompat_Dark);
        builder.setCancelable(false);
        builder.setMessage("All information given here is Google based. Before following any of the " +
                "diet Consult your Doctor first.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
        WindowManager.LayoutParams lp=new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width=700;
        lp.height=300;
        lp.x=-300;
        lp.y=300;
        dialog.getWindow().setAttributes(lp);

    }
}
