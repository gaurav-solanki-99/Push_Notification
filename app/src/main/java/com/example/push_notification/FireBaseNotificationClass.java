package com.example.push_notification;

import android.app.NotificationChannelGroup;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.push_notification.utils.NotificationHelper;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FireBaseNotificationClass  extends FirebaseMessagingService
{

    public FireBaseNotificationClass() {
        super();
    }

    @Override
    public void onMessageReceived(@NonNull  RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String body= remoteMessage.getNotification().getBody();
        String title= remoteMessage.getNotification().getTitle();

        NotificationHelper helper = new NotificationHelper(this);

        if (remoteMessage.getNotification().getImageUrl() == null || remoteMessage.getNotification().getImageUrl().toString().equalsIgnoreCase("null") || remoteMessage.getNotification().getImageUrl().toString().equalsIgnoreCase(""))
        {
            helper.triggerNotificatio(title,body);



        }else
        {
            String image =remoteMessage.getNotification().getImageUrl().toString();
            helper.triggerNotificatio(title,body,image);
        }


    }
}
