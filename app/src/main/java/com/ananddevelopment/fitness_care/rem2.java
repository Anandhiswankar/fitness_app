package com.ananddevelopment.fitness_care;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class rem2 extends AppCompatActivity {
    TextView rem_2__title;
    Button rem2_save_btn, rem2_del_btn;
    TimePicker rem2_clock;
    public int Hour, Minute;
    ReminderDB remdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem2);
        remdb = new ReminderDB(this);

        rem2_save_btn = findViewById(R.id.rem2_save_btn);
        rem_2__title = findViewById(R.id.rem_2__title);
        rem2_clock = findViewById(R.id.rem2_clock);
        rem2_del_btn=findViewById(R.id.rem2_del_btn);
        rem2_del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete();
            }
        });
        show();
        rem2_clock.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Hour = hourOfDay;
                Minute = minute;
            }
        });
    }

    public void setTimer (View v){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Date date = new Date();
        Calendar cal_Alarm = Calendar.getInstance();
        Calendar cal_Now = Calendar.getInstance();
        cal_Now.setTime(date);
        cal_Alarm.setTime(date);

        cal_Alarm.set(Calendar.HOUR_OF_DAY, Hour);
        cal_Alarm.set(Calendar.MINUTE, Minute);
        cal_Alarm.set(Calendar.SECOND, 0);

        if (cal_Alarm.before(cal_Now))
        {
            cal_Alarm.add(Calendar.DATE, 1);
        }
        Intent i = new Intent(rem2.this, broadcast2.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(rem2.this, 0, i, 0);
        //alarmManager.set(AlarmManager.RTC_WAKEUP, cal_Alarm.getTimeInMillis(), pendingIntent);24444
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal_Alarm.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        save();


    }

    public void show()
    {
        Cursor cursor=remdb.getData2();
        StringBuffer stringBuffer=new StringBuffer();    // this code get data from cursor
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append(""+cursor.getString(1)+"\n");
                stringBuffer.append("\n");
            }
            rem_2__title.setText(stringBuffer.toString());   //display this list in textview
            Toast.makeText(this,"Loading..",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No History",Toast.LENGTH_SHORT).show();
        }

    }
    private void save ()
    {

        String rem = rem_2__title.getText().toString();
        String hour = String.valueOf(Hour);
        String min= String.valueOf(Minute);

        if (TextUtils.isEmpty(rem_2__title.getText())) {
            rem_2__title.setError("Required...");
            return;
        }
        Boolean result = remdb.insertData2(rem,hour,min);
        if (result == true)
        {
            Toast.makeText(this, "Alarm is set to " +hour +": "+min, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Something Wrong", Toast.LENGTH_SHORT).show();
        }


    }

    public void Delete()
    {
        try {
            rem_2__title.setText("");
            String id = String.valueOf(rem_2__title.getId());
            int res = remdb.DeleteData(id);
            Toast.makeText(this, " Task 2 Deleted", Toast.LENGTH_SHORT).show();
        } catch (Exception err) {
            Toast.makeText(this,"error:" + err.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}

