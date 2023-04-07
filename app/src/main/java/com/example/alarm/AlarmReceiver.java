package com.example.alarm;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Start the alarm service
        Log.i("alarm", "inside receiver");
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.audio);
        mediaPlayer.start();
        Intent serviceIntent = new Intent(context, AlarmClose.class);
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            for (String key : bundle.keySet()) {
                Log.i("inside receiver", key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
            }
        }
        context.startService(serviceIntent);
    }
}

