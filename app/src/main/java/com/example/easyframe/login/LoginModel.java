package com.example.easyframe.login;

import com.example.easyframe.mvp.base.BaseModel;

public class LoginModel extends BaseModel<LoginView> {
    public LoginModel(LoginView presenter) {
        super(presenter);
    }

    public void getLogin(){
        mPresenter.loginSuccess();
    }


}
