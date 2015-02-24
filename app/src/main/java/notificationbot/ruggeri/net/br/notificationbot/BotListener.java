package notificationbot.ruggeri.net.br.notificationbot;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by diego on 23/02/15.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BotListener extends NotificationListenerService {

    private static final String TAG = BotListener.class.getSimpleName();

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        Log.d(TAG, "onNotificationPosted");
        if (null == statusBarNotification) return;

        Notification not = statusBarNotification.getNotification();

        Log.d(TAG, not.tickerText.toString());
        for(String key : not.extras.keySet()){
            logExtra(not, key);
        }

        Log.d(TAG, not.actions == null ? "no action" : "has actions");

    }

    private void logExtra(Notification n, String key){
        if(null != n && null != n.extras && n.extras.containsKey(key)
                && n.extras.get(key) instanceof String){
            Log.d(TAG, key + " : " + n.extras.getString(key));
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {

    }
}
