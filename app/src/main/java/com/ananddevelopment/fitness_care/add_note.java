package com.ananddevelopment.fitness_care;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class add_note extends AppCompatActivity {
    DataBaseHelper dbh;
    EditText note_box;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        note_box= findViewById(R.id.note_box);
        save_button= findViewById(R.id.save_button);
        Animation pop_up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.pop_up);

        save_button.setAnimation(pop_up);

        dbh=new DataBaseHelper(this);
        show();
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }});
    }
    private void show()
    {
        Cursor cursor=dbh.getData();
        StringBuffer stringBuffer=new StringBuffer();
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append(""+cursor.getString(1)+"\n");
                stringBuffer.append("\n");
            }
            note_box.setText(stringBuffer.toString());
            Toast.makeText(this,"Loading..",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No History",Toast.LENGTH_SHORT).show();
        }

    }private void save() {
        String task=note_box.getText().toString();
        if(TextUtils.isEmpty(note_box.getText()))
        {
            note_box.setError("Required ...");
            return;
        }
        int id=dbh.getData().getColumnIndex("id");
        Boolean result= dbh.updateData(id, task);
        if(result==true)
            if (dbh.updateData(id, task)) {
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
            }
        //    Intent intent=new Intent(MainActivity.this,savedData.class);
        //  startActivity(intent);
    }



}



