package com.example.push_notification;

import android.app.NotificationChannelGroup;

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

       String body= remoteMessage.getNotification().getBody().toString();
        String title= remoteMessage.getNotification().getTitle().toString();
        String image =remoteMessage.getNotification().getImageUrl().toString();


        NotificationHelper helper = new NotificationHelper(this);
//        helper.triggerNotificatio(title,body);

        helper.triggerNotificatio(title,body,image);






    }
}
