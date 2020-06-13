package com.ananddevelopment.fitness_care;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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

        AdView down = findViewById(R.id.ads_rem_bottom);


        AdRequest adRequest = new AdRequest.Builder().build();


        down.loadAd(adRequest);

        rem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(reminder.this,rem1.class);
                startActivity(intent);
                finish();
            }
        });

        rem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reminder.this,rem2.class);
                startActivity(intent);
                finish();
            }
        });

        rem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reminder.this,rem3.class);
                startActivity(intent);
                finish();
            }
        });

        rem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(reminder.this,rem4.class);
                startActivity(intent);

                finish();
            }
        });


    }
    public  void  show1()
    {
        try {
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
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public  void  show2()
    {
        try {
            Cursor cursor = remdb.getData2();
            StringBuffer stringBuffer = new StringBuffer();    // this code get data from cursor
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    stringBuffer.append("\n");
                    stringBuffer.append("" + cursor.getString(2) + ":" + cursor.getString(3) + "" + cursor.getString(4) + "\n");
                }
                rem2Text.setText(stringBuffer.toString());   //display this list in textview
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public  void  show3()
    {
        try {
            Cursor cursor = remdb.getData3();
            StringBuffer stringBuffer = new StringBuffer();    // this code get data from cursor
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    stringBuffer.append("\n");
                    stringBuffer.append("" + cursor.getString(2) + ":" + cursor.getString(3) + "" + cursor.getString(4) + "\n");
                }
                rem3Text.setText(stringBuffer.toString());   //display this list in textview
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public  void  show4()
    {
        try {
            Cursor cursor = remdb.getData4();
            StringBuffer stringBuffer = new StringBuffer();    // this code get data from cursor
            if (cursor != null && cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    stringBuffer.append("\n");
                    stringBuffer.append("" + cursor.getString(2) + ":" + cursor.getString(3) + "" + cursor.getString(4) + "\n");
                }
                rem4Text.setText(stringBuffer.toString());   //display this list in textview
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
