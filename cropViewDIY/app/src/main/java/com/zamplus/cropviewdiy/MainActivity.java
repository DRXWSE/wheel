package com.zamplus.cropviewdiy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private CropImageView mView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.text);
        mView = (CropImageView) findViewById(R.id.cropimage);
        //设置资源和默认长宽
        mView.setDrawable(getResources().getDrawable(R.mipmap.logo), 300, 300);
        //调用该方法得到剪裁好的图片
//        Bitmap mBitmap = mView.getCropImage();
    }

    public void test(View view) {
        Bitmap mBitmap = mView.getCropImage();
        Toast.makeText(getApplicationContext(), mBitmap.toString(), Toast.LENGTH_SHORT).show();
        Glide.with(this).load(mBitmap).into(imageView);
    }
}