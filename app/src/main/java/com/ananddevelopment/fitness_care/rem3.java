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

public class rem3 extends AppCompatActivity {
    TextView rem_3__titile;
    Button rem3_save_btn, rem3_del_btn;
    TimePicker rem3_clock;
    public int Hour, Minute;
    ReminderDB remdb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem3);
        remdb = new ReminderDB(this);

        rem3_save_btn = findViewById(R.id.rem3_save_btn);
        rem_3__titile = findViewById(R.id.rem_3__titile);
        rem3_clock = findViewById(R.id.rem3_clock);
        rem3_del_btn=findViewById(R.id.rem3_del_btn);
        rem3_del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete();
            }
        });
        show();
        rem3_clock.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
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
        Intent i = new Intent(rem3.this, broadcast3.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(rem3.this, 0, i, 0);
        //alarmManager.set(AlarmManager.RTC_WAKEUP, cal_Alarm.getTimeInMillis(), pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,cal_Alarm.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        save();


    }

    public void show()
    {
        Cursor cursor=remdb.getData3();
        StringBuffer stringBuffer=new StringBuffer();    // this code get data from cursor
        if (cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                stringBuffer.append(""+cursor.getString(1)+"\n");
                stringBuffer.append("\n");
            }
            rem_3__titile.setText(stringBuffer.toString());   //display this list in textview
            Toast.makeText(this,"Loading..",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"No History",Toast.LENGTH_SHORT).show();
        }

    }
    private void save ()
    {
        String rem = rem_3__titile.getText().toString();
        String hour = String.valueOf(Hour);
        String min  = String.valueOf(Minute);
        if (TextUtils.isEmpty(rem_3__titile.getText())) {
            rem_3__titile.setError("Required...");
            return;
        }
        Boolean result = remdb.insertData3(rem,hour,min);
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
            rem_3__titile.setText("");
            String id = String.valueOf(rem_3__titile.getId());
            int res = remdb.DeleteData3(id);

            Toast.makeText(this,  " Task 3 Deleted", Toast.LENGTH_SHORT).show();
        } catch (Exception err) {
            Toast.makeText(this,"error:" + err.toString(),Toast.LENGTH_SHORT).show();
        }

    }

}
