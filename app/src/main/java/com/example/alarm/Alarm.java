package com.example.alarm;

import android.annotation.SuppressLint;

public class Alarm {
    private int mHour;
    private int mMinute;
    private String message;

    public Alarm(int hour, int minute, String message) {
        mHour = hour;
        mMinute = minute;
        this.message = message;
    }

    public int getHour() {
        return mHour;
    }

    public int getMinute() {
        return mMinute;
    }

    @SuppressLint("DefaultLocale")
    public String getTime() {
        return String.format("%02d:%02d", mHour, mMinute) + "\n" + message;
    }
}
