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

        // Button zum Ausloesen der Notification: OnClickListener setzen
        showNtfc = (Button) findViewById(R.id.showNtfc);
        showNtfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNotification();
            }
        });
    }

    /**
     * Methode zum Erstellen und Ausloesen einer einfachen Notification:
     * enthaelt Channel-ID, NotificationBuilder und Intent
     * Basiert auf folgendem Skript:
     * https://developer.android.com/guide/topics/ui/notifiers/notifications.html
     */

    private void createNotification() {


        // Die Channel-ID
        String CHANNEL_ID = "my_channel_01";

        //Notification: Inhalt & Look
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_stat_textsms)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!")
                        .setVibrate(new long[]{400, 700, 500}) //Vibrieren
                        // Set the notification to cancel when the user taps on it
                        .setAutoCancel(true);
        // Intent spezifiziert eine Activity in der App, welche von der Notification aufgerufen werden soll

        Intent resultIntent = new Intent(this, ResultActivity.class);

        // mNotificationId ist eine Zahl-ID, mit welcher die App die Notification identifizieren kann.
        // Die ID der Notification kann an eine Methode uebergeben werden,
        // z.B. um die Notification zu loeschen: NotificationManager.cancel().
        int mNotificationId = 1;

        // Gibt Metadaten zum Intent hinzu, hier die NotificationId,
        // um die Notification in der ResultActivity canceln zu koennen
        resultIntent.putExtra("notifyID", mNotificationId);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        mBuilder.setContentIntent(resultPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // ActionButton fuer Expanded View
        mBuilder.addAction(R.drawable.ic_stat_textsms, "Loes was aus", resultPendingIntent);

        mNotificationManager.notify(mNotificationId, mBuilder.build());

    }
}
