package com.example.easyframe;

import android.view.View;
import android.os.Bundle;
import com.example.easyframe.base.EasyBaseActivity;
import com.example.easyframe.toolmodel.EasyLog;
import com.example.easyframe.toolmodel.EasyMMKV;



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
                showProgress("dsds");
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