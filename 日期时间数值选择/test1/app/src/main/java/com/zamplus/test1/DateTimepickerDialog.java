package com.zamplus.test1;

import java.util.Calendar;
import java.util.logging.Handler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class DateTimepickerDialog extends AlertDialog {
    private DateTimepicker mDateTimePicker;
    private Calendar mDate = Calendar.getInstance();
    private int Hour, Minute, Second;
    private OnDateTimeSetListener mOnDateTimeSetListener;
    private String datetimeStr;
    private String hour;
    private String minute;
    private String second;

    public DateTimepickerDialog(Context context, long date) {
        super(context);
        mDateTimePicker = new DateTimepicker(context);
        setView(mDateTimePicker);//装载刚才建立的布局，把定义好的日期时间布局显示在这个自定义对话框上
        /*
         *实现DateTimepicker里的接口
         */
        mDateTimePicker.setOnDateTimeChangedListener(new DateTimepicker.OnDateTimeChangedListener() {
            public void onDateTimeChanged(DateTimepicker view,
                                          int hour, int minute, int second) {

                Hour = hour;
                Minute = minute;
                Second = second;
            }
        });
        setTitle("请选择时间");

        Hour = 0;
        Minute = 0;
        Second = 0;
        setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                //处理显示格式话的问题
                if (Hour < 10) {
                    hour = String.valueOf(Hour);
                    hour = "0" + hour;
                }
                if (Minute < 10) {
                    minute = String.valueOf(Minute);
                    minute = "0" + Minute;
                }
                if (Second < 10) {
                    second = String.valueOf(Second);
                    second = "0" + Second;
                }
                datetimeStr = hour + ":" + minute + ":" + second;
                if (mOnDateTimeSetListener != null) {
                    mOnDateTimeSetListener.OnDateTimeSet(dialog, datetimeStr);
                }
            }
        });
        setButton(DialogInterface.BUTTON_NEGATIVE, "取消", (OnClickListener) null);
        setCanceledOnTouchOutside(false);//点击对话框外无法关闭对话框
    }

    /*
     *
     *接口回调
     */
    public interface OnDateTimeSetListener {
        void OnDateTimeSet(DialogInterface dialog, String datetimestr);
    }


    /*
     *对外公开方法让Activity实现
     */
    public void setOnDateTimeSetListener(OnDateTimeSetListener callBack) {
        mOnDateTimeSetListener = callBack;
    }
}