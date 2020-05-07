package com.zamplus.stringarrayindexof;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    //多选字典
    String test = "NIKE,Adidas,Asics,Mizuno,New Balance,PUMA,LI-NING,Saucony,Brooks,Do-win,Kalenji,personarchives.shoesbrand12,斯凯奇 Skechers,其他";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int position = Arrays.binarySearch(shenTiZhuangKuang, "良好");
        Utils utils = new Utils();

        String[] result = test.split(",");

        List<String> strings = utils.getChuanzhuopaoxiepinpai();
        List<String> strings1 = Arrays.asList(shenTiZhuangKuang);


        //先将数组转成集合，再用集合的indexOf来查


        //多选用这个查
        for (int i = 0; i < result.length; i++) {
            int i1 = strings.indexOf(result[i]);
            Log.e(TAG, "onCreate:------------------------------------------" + i1);
        }

        //单选
        int rr = strings1.indexOf("良好");
        Log.e(TAG, "单选" + rr);
    }
}
