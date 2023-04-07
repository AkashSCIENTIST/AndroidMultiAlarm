package com.example.alarm;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mAlarmListView;
    private ArrayList<Alarm> mAlarmList;
    private AlarmAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlarmListView = findViewById(R.id.alarm_list_view);
        mAlarmList = new ArrayList<>();
        mAdapter = new AlarmAdapter(this, mAlarmList);
        mAlarmListView.setAdapter(mAdapter);

        // Add a new alarm
        findViewById(R.id.add_alarm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(MainActivity.this, SetAlarmActivity.class);

                    startActivityForResult(intent, 1);
                }
                catch(Exception ex){
                    Log.e("alarm", ex.toString());
                }
            }
        });

        // Delete an alarm
        mAlarmListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                mAlarmList.remove(position);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    // Receive the alarm data from SetAlarmActivity and add it to the list
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            int hour = data.getIntExtra("hour", 0);
            int minute = data.getIntExtra("minute", 0);
            String str = data.getStringExtra("str");
            Alarm alarm = new Alarm(hour, minute, str);
            mAlarmList.add(alarm);
            mAdapter.notifyDataSetChanged();
        }
    }
}
