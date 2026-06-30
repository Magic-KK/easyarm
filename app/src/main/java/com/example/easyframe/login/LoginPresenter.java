package com.example.easyframe.login;

import com.example.easyframe.mvp.base.BasePresenter;

/**
 * 示例 Presenter：连接 LoginActivity(View) 与 LoginModel(Model)。
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginModel model;

    @Override
    public void ModelBinding() {
        model = new LoginModel(this);
    }

    public void getLogin() {
        // View 的点击事件只通知 Presenter，具体数据动作交给 Model。
        model.getLogin();
    }

    public void result() {
        if (isAttachView()) {
            mView.loginSuccess();
        }
    }
}
