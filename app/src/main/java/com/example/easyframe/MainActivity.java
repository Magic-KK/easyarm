package com.example.easyframe;

import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.easyframe.base.EasyBaseActivity;
import com.example.easyframe.utils.EasyLog;
import com.example.easyframe.utils.EasyMMKV;


public class MainActivity extends EasyBaseActivity {


    @Override
    public void initView(Bundle savedInstanceState) {
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long start = System.currentTimeMillis();
                long end = 0;
                for (int i = 0; i < 100000; i++) {
                    EasyMMKV.save("ll", i + "");
                    end = System.currentTimeMillis();
                }

                EasyLog.d((end - start) + "");
            }
        });


        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EasyLog.d(EasyMMKV.getString("ll"));
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }
}