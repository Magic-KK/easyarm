package com.example.easyframe.login;

import com.example.easyframe.mvp.intef.IBaseView;

/**
 * 登录示例的 View 协议，Presenter 通过它把结果回传给页面。
 */
public interface LoginView extends IBaseView {

    void loginSuccess();
}
