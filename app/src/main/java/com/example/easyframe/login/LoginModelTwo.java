package com.example.easyframe.login;

import com.example.easyframe.mvp.base.BaseModel;

public class LoginModelTwo extends BaseModel<LoginView> {
    public LoginModelTwo(LoginView presenter) {
        super(presenter);
    }

    public void getLogin(){
        mPresenter.loginSuccess();
    }


}
