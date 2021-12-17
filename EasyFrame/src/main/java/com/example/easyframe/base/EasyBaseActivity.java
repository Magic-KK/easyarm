package com.example.easyframe.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * BaseActivity
 */
public abstract class EasyBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        initView(savedInstanceState);
        initListener();
        initData();
    }

    public abstract void initView(Bundle savedInstanceState);

    public abstract void initListener();

    public abstract void initData();

    public abstract int getActivityLayoutId();


}
