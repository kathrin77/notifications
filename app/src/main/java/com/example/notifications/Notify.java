package com.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/* Created by kathr on 02.12.2017.
 * Versuch nach Talbot, Learning Android programming, funktioniert so aber nicht, da fehlt noch code
 * von einem andern Appbeispiel aus dem Buch.
 *
 * In der main dann irgendwie so:
 * Notify notify = new Notify(this);
 * notify.notifyCheck();
 *
 * Dazu in der strings.xml noch:
 *     <string name="time_running_ticker">Keep going!</string>
    <string name="time_running_message">You have been riding for %1$02d:%2$02d. Keep it up!</string>
    <string name="time_start_ticker">On your way!</string>
    <string name="time_start_messae">You have just started.</string>
 */

/*
public class Notify {
    private static String CLASS_NAME;
    private final NotificationManager manager;
    private final Context context;
    public int smallIcon = R.drawable.ic_launcher_background;
    private static final int MESSAGE_ID = 1;

    public Notify(Activity activity) {
        CLASS_NAME = getClass().getName();
        manager = (NotificationManager) activity
                .getSystemService(Context.NOTIFICATION_SERVICE);
        context = activity.getApplicationContext();
    }

    private Notification create(String title, String message, long when) {

        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setWhen(when)
                .setSmallIcon(smallIcon).build();
        notification.d(CLASS_NAME, "create()");

        return notification;
    }

    public void notify(String title, String message) {
        Log.d(CLASS_NAME, "notify()");
        Notification notification = create(title,message,System.currentTimeMillis());

        manager.notify(MESSAGE_ID, notification);
    }

    public void notify(String title, String message, long when) {
        Log.d(CLASS_NAME, "notify()");
        Notification notification = create(title, message, when);

        manager.notify(MESSAGE_ID, notification);
    }

    public void notifyCheck() {
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;

        Log.d(CLASS_NAME, "notifyCheck()");

        timer.elapsedTime();

        seconds = timer.seconds();
        minutes = timer.minutes();
        hours = timer.hours();

        if (minutes % 15 == 0 && seconds == 0 && seconds != lastSeconds) {
            String title = getResources().getString(R.string.time_title);
            String message = getResources().getString(R.string.time_running_message);

            if (hours == 0 && minutes == 0) {
                message = getResources().getString(R.string.time_start_message);
            }

            message = String.format(message, hours, minutes);

            notify.notify(title,message);
        }
        lastSeconds = seconds;

    }
}
*/
