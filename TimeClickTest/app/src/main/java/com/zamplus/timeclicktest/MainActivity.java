package com.zamplus.timeclicktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date date = new Date();

        String s = date.toString();
        long time = date.getTime();

        Log.e("md", "时间string.time为： " + s);
        Log.e("md", "时间long.time为： " + time);


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sim = dateFormat.format(date);
        Log.e("md", "时间sim为： " + sim);
    }
}
