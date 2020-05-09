package com.ananddevelopment.fitness_care;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class my_profile extends AppCompatActivity {
    EditText U_name,U_gender,U_age,U_weight,U_height;
    Button btnsave;
    db_userProfile userProfileDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        userProfileDb=new db_userProfile(this);
        U_name=findViewById(R.id.U_name);
        U_gender=findViewById(R.id.U_gender);
        U_age=findViewById(R.id. U_age);
        U_weight=findViewById(R.id. U_weight);
        U_height=findViewById(R.id.U_height);
        btnsave=findViewById(R.id.btnsave);

        Animation pop_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop_up);

        btnsave.setAnimation(pop_up);
        show();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                save();
            }
        });

    }
    private void show() {
        Cursor cursor = userProfileDb.getData();

       StringBuffer stringBuffer = new StringBuffer();
         if (cursor != null && cursor.getCount() > 0)
         {


          while (cursor.moveToNext()) {

               String name1=cursor.getString(1);
               U_name.setText(name1);
               String Gender=cursor.getString(2);
               U_gender.setText(Gender);
               String Age=cursor.getString(3);
               U_age.setText(Age);
              String Weight=cursor.getString(4);
               U_weight.setText(Weight);
               String Height =cursor.getString(5);
               U_height.setText(Height);


           }

             Toast.makeText(this, "Loading..", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "No History", Toast.LENGTH_SHORT).show();
        }
    }

    private void save() {
        String Name =U_name .getText().toString();
        String Age = U_age.getText().toString();
        String Height = U_height.getText().toString();
        String Weight = U_weight.getText().toString();
        String Gender = U_gender.getText().toString();
        if (TextUtils.isEmpty(U_name.getText())) {
            U_name.setError("Fill your Name Please");
            return;
        }
        if (TextUtils.isEmpty(U_gender.getText())) {
            U_gender.setError("Required...");
            return;
        }
        if (TextUtils.isEmpty(U_age.getText())) {
            U_age.setError("Required...");
            return;
        }
        if (TextUtils.isEmpty(U_height.getText())) {
            U_height.setError("Required...");
            return;
        }
        if (TextUtils.isEmpty(U_weight.getText())) {
            U_weight.setError("Required...");
            return;
        }
        int id = userProfileDb.getData().getColumnIndex("id");
        Boolean result = userProfileDb.insertData(id, Name, Gender, Age, Weight, Height);
        if (result == true)
            if (userProfileDb.insertData(id, Name, Gender, Age, Weight, Height)) {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }
    }
}
