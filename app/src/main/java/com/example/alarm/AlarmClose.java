package com.example.alarm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmClose  extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_alarm);
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    public void close(View view){
        mediaPlayer.stop();
    }
}
