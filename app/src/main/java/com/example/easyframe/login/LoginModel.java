package com.example.easyframe.login;

import com.example.easyframe.mvp.base.BaseModel;

public class LoginModel extends BaseModel<LoginPresenter> {
    public LoginModel(LoginPresenter presenter) {
        super(presenter);
    }

    public void getLogin(){
        mPresenter.result();
    }


}
