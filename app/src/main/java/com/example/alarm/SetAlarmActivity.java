package com.example.alarm;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
public class SetAlarmActivity extends AppCompatActivity {

    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        timePicker = findViewById(R.id.time_picker);
        Button saveButton = findViewById(R.id.save_alarm_button);
        EditText editText = findViewById(R.id.content);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String str = String.valueOf(editText.getText());

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                Intent intent = new Intent(SetAlarmActivity.this, AlarmReceiver.class);
                intent.putExtra("Hour", ""+hour);
                intent.putExtra("Minute", ""+minute);
                intent.putExtra("Data", "Reason");
                @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent = PendingIntent.getBroadcast(SetAlarmActivity.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                Intent data = new Intent();
                data.putExtra("hour", hour);
                data.putExtra("minute", minute);
                data.putExtra("str", str);
                setResult(RESULT_OK, data);
                Toast.makeText(SetAlarmActivity.this, "Alarm set for " + hour + ":" + minute, Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
