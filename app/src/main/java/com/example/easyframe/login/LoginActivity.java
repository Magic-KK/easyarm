package com.example.easyframe.login;

import android.os.Bundle;
import android.view.View;

import com.example.easyframe.R;
import com.example.easyframe.mvp.CreatePresenter;
import com.example.easyframe.mvp.PresenterVariable;
import com.example.easyframe.mvp.base.EasyBaseMvpActivity;
@CreatePresenter(presenter = {LoginPresenter.class})

public class LoginActivity extends EasyBaseMvpActivity implements LoginView {
    @PresenterVariable LoginPresenter mPre;


    @Override
    public void initView(Bundle savedInstanceState) {
        findViewById(R.id.ss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPre.getLogin();
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
        return R.layout.testb;
    }

    @Override
    public void loginSuccess() {
        showToast("ss");
    }
}
