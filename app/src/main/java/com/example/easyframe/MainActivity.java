package com.example.easyframe;

import android.content.Intent;
import android.os.Bundle;

import com.example.easyframe.base.EasyBaseActivity;
import com.example.easyframe.login.LoginActivity;
import com.example.easyframe.toolmodel.EasyMMKV;

/**
 * 基础页面示例：演示 EasyBaseActivity 的模板方法，以及 EasyMMKV 的保存和读取。
 */
public class MainActivity extends EasyBaseActivity {

    private static final String DEMO_STORAGE_ID = "demo_user";
    private static final String DEMO_TOKEN_KEY = "token";
    private static final String DEMO_TOKEN_VALUE = "easyarm-demo-token";

    @Override
    public void initView(Bundle savedInstanceState) {
        // 页面控件由 activity_main.xml 提供，这里保留给视图初始化。
    }

    @Override
    public void initListener() {
        findViewById(R.id.button_save_demo).setOnClickListener(v -> saveDemoToken());
        findViewById(R.id.button_get_demo).setOnClickListener(v -> showSavedToken());
        findViewById(R.id.button_open_mvp_demo).setOnClickListener(v -> openMvpDemo());
    }

    @Override
    public void initData() {
        // 当前示例没有远程数据，数据由按钮点击写入 MMKV。
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_main;
    }

    private void saveDemoToken() {
        EasyMMKV.save(DEMO_STORAGE_ID, DEMO_TOKEN_KEY, DEMO_TOKEN_VALUE);
        showToast(R.string.demo_mmkv_save_success);
    }

    private void showSavedToken() {
        String token = EasyMMKV.getString(DEMO_STORAGE_ID, DEMO_TOKEN_KEY, "");
        if (token.isEmpty()) {
            showToast(R.string.demo_mmkv_token_empty);
            return;
        }
        showToast(getString(R.string.demo_mmkv_token_format, token));
    }

    private void openMvpDemo() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
