package com.example.push_notification.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.push_notification.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NotificationHelper
{
    private Context context;
    private static final  int id  =100;


    public NotificationHelper(Context context) {
        this.context = context;
    }

  public void triggerNotificatio(String title,String body)
    {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                  .setSmallIcon(R.drawable.ic_insta)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat managerCompat =NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());


    }


    public void triggerNotificatio(String title,String body,String image)
    {
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context,Constants.id)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_insta)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(getBitmapFromURL(image)));
        NotificationManagerCompat managerCompat =NotificationManagerCompat.from(context);
        managerCompat.notify(id,builder.build());


    }


    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
