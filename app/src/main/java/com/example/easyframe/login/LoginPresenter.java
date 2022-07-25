package com.example.easyframe.login;

import com.example.easyframe.mvp.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView> {
    LoginModel model ;


    @Override
    public void ModelBinding() {
        model = new LoginModel(this);
    }

    public void getLogin(){
        model.getLogin();
    }

    public void result(){
        mView.loginSuccess();
    }


}
