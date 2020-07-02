package com.zamplus.mimakuang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

public class MainActivity extends AppCompatActivity {
    private boolean isHidden = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImgEditText pwdIet = (ImgEditText) this.findViewById(R.id.pwdIet);
        pwdIet.setDrawableClick(new ImgEditText.IMyRightDrawableClick() {
            @Override
            public void rightDrawableClick() {
                if (isHidden) {
                    //设置EditText文本为可见的
                    pwdIet.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    pwdIet.setRightDrawable(getResources().getDrawable(R.mipmap.biyan));
                } else {
                    //设置EditText文本为隐藏的
                    pwdIet.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    pwdIet.setRightDrawable(getResources().getDrawable(R.mipmap.zhengyan));
                }
                isHidden = !isHidden;
                pwdIet.postInvalidate();
                    //切换后将EditText光标置于末尾
                CharSequence charSequence = pwdIet.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
            }
        });
    }
}