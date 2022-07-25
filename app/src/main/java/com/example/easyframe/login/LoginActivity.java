package com.example.easyframe.login;

import android.os.Bundle;

import com.example.easyframe.mvp.CreatePresenter;
import com.example.easyframe.mvp.PresenterVariable;
import com.example.easyframe.mvp.base.EasyBaseMvpActivity;
@CreatePresenter(presenter = {LoginPresenter.class})

public class LoginActivity extends EasyBaseMvpActivity implements LoginView {
    @PresenterVariable LoginPresenter mPre;


    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getActivityLayoutId() {
        return 0;
    }

    @Override
    public void loginSuccess() {

    }
}
