package com.zamplus.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author: Alex Yin
 * @describe:
 * @date: 2020-2-23 10:37:50
 */

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        DateTimepickerDialog datetimedialog = new DateTimepickerDialog(MainActivity.this,System.currentTimeMillis());
/**
 *   * 实现接口
 */
        datetimedialog.setOnDateTimeSetListener(new DateTimepickerDialog.OnDateTimeSetListener() {
            public void OnDateTimeSet(DialogInterface dialog, String datetimestr) {
                textView.setText(datetimestr);
            }
        });
        datetimedialog.show();
    }
}
