package com.ananddevelopment.fitness_care;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.widget.Toast;

public class Broadcast extends BroadcastReceiver {


        public void onReceive(Context context, Intent intent) {

           ReminderDB remdb = new ReminderDB(context);

            Cursor cursor=remdb.getData();

            StringBuffer stringBuffer=new StringBuffer();

            if (cursor!=null && cursor.getCount()>0)
            {
                while (cursor.moveToNext())
                {
                    stringBuffer.append(""+cursor.getString(1)+"\n");
                    stringBuffer.append("\n");
                }
            }


            Vibrator vibrator= (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);

            Uri notification= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r=RingtoneManager.getRingtone(context,notification);



                Toast.makeText(context, "Reminder for " + stringBuffer.toString(), Toast.LENGTH_SHORT).show();
                String msg = "Reminder for " + stringBuffer.toString();


            createnoticahannel(context);
            NotificationCompat.Builder builder= new NotificationCompat.Builder(context,"fitness_care")
                    .setContentTitle("Fitness Care")
                    .setContentText(msg)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setSmallIcon(R.drawable.notif)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);

            if(stringBuffer.toString()!="")
            {
                vibrator.vibrate(2000);
                notificationManagerCompat.notify(0,builder.build());
                r.play();

            }


        }


    private void createnoticahannel(Context context)
    {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            CharSequence name = "fitness_care";
            String desc = "Alert Data";

            int imp = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel("fitness_care",name,imp);

            notificationChannel.setDescription(desc);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void show() {

    }


}


