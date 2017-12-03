package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Button zum Ausloesen der Notification
    Button showNtfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button zum Ausloesen der Notification
        showNtfc = (Button) findViewById(R.id.showNtfc);
        showNtfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    private void createNotification() {

        // Creating a simple notification:
        // https://developer.android.com/guide/topics/ui/notifiers/notifications.html

        // The id of the channel.
        String CHANNEL_ID = "my_channel_01";

        //Notification: Inhalt & Look
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_stat_textsms)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setVibrate(new long[] {400,700,500}) //hinzugefügt nach Uwe Post, Vibrieren
                        // Set the notification to cancel when the user taps on it
                        .setAutoCancel(true);
        // Creates an explicit intent for an Activity in your app
        //original:
        Intent resultIntent = new Intent(this, ResultActivity.class);
        //geändert zu MainActivity, da keine ResultActivity gebaut:
        //Intent resultIntent = new Intent(this, MainActivity.class);


        // The stack builder object will contain an artificial back stack for the
        // started Activity.
        // This ensures that navigating backward from the Activity leads out of
        // your app to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        //original:
        stackBuilder.addParentStack(ResultActivity.class);
        //geändert zu (siehe oben)
        //stackBuilder.addParentStack(MainActivity.class);

        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // mNotificationId is a unique integer your app uses to identify the
        // notification. For example, to cancel the notification, you can pass its ID
        // number to NotificationManager.cancel().
        int mNotificationId = 1;
        mNotificationManager.notify(mNotificationId, mBuilder.build());

/* Gemäss Buch von Uwe Post, Android-Apps entwickeln für Einsteiger, reicht auch einfach das hier:
(und das funktioniert auch, getestet). Dazu braucht es in der StringXML noch folgenden Eintrag:
    <string name="hello_world">Hallo Welt!</string>

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setVibrate(new long[] {400,700,500})
                .setContentTitle(getText(R.string.app_name))
                .setContentText(getText(R.string.hello_world))
                .setWhen(System.currentTimeMillis()+2000)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent);

        Notification notification = builder.build();

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(1,notification);*/
    }
}
