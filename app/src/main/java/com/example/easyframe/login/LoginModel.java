package com.example.easyframe.login;

import com.example.easyframe.mvp.base.BaseModel;

/**
 * 示例 Model：模拟登录请求成功，便于观察 MVP 调用链。
 */
public class LoginModel extends BaseModel<LoginPresenter> {

    public LoginModel(LoginPresenter presenter) {
        super(presenter);
    }

    public void getLogin() {
        // 实际项目可在这里调用网络或数据库，本示例直接返回成功结果。
        mPresenter.result();
    }
}
