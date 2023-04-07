package com.example.alarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AlarmAdapter extends ArrayAdapter<Alarm> {
    private Context mContext;

    public AlarmAdapter(Context context, ArrayList<Alarm> alarms) {
        super(context, 0, alarms);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.alarm_list_item, parent, false);
        }

        Alarm alarm = getItem(position);

        TextView timeTextView = convertView.findViewById(R.id.time_text_view);
        timeTextView.setText(alarm.getTime());

        return convertView;
    }
}

