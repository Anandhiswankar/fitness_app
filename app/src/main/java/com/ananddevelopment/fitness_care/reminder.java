package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class reminder extends AppCompatActivity {
    ImageView rem1,rem2,rem3,rem4;
    ReminderDB remdb;
    TextView rem1Text,rem2Text,rem3Text,rem4Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        remdb=new ReminderDB(this);
        rem1=findViewById(R.id.rem1);
        rem2=findViewById(R.id.rem2);
        rem3=findViewById(R.id.rem3);
        rem4=findViewById(R.id.rem4);
        rem1Text=findViewById(R.id.rem1Text);
        rem2Text=findViewById(R.id.rem2Text);
        rem3Text=findViewById(R.id.rem3Text);
        rem4Text=findViewById(R.id.rem4Text);

        show1();
        show2();
        show3();
        show4();



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
    public  void  show1()
    {
        Cursor cursor=remdb.getData();
        StringBuffer stringBuffer=new StringBuffer();    // this code get data from cursor
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append("\n");
                stringBuffer.append(""+cursor.getString(2)+":"+cursor.getString(3)+""+cursor.getString(4)+"\n");
            }
        rem1Text.setText(stringBuffer.toString());   //display this list in textview
        }
    }
    public  void  show2()
    {
        Cursor cursor=remdb.getData2();
        StringBuffer stringBuffer=new StringBuffer();    // this code get data from cursor
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append("\n");
                stringBuffer.append(""+cursor.getString(2)+":"+cursor.getString(3)+""+cursor.getString(4)+"\n");
            }
            rem2Text.setText(stringBuffer.toString());   //display this list in textview
        }
    }
    public  void  show3()
    {
        Cursor cursor=remdb.getData3();
        StringBuffer stringBuffer=new StringBuffer();    // this code get data from cursor
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append("\n");
                stringBuffer.append(""+cursor.getString(2)+":"+cursor.getString(3)+""+cursor.getString(4)+"\n");
            }
            rem3Text.setText(stringBuffer.toString());   //display this list in textview
        }
    }
    public  void  show4()
    {
        Cursor cursor=remdb.getData4();
        StringBuffer stringBuffer=new StringBuffer();    // this code get data from cursor
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append("\n");
                stringBuffer.append(""+cursor.getString(2)+":"+cursor.getString(3)+""+cursor.getString(4)+"\n");
            }
            rem4Text.setText(stringBuffer.toString());   //display this list in textview
        }
    }
}
