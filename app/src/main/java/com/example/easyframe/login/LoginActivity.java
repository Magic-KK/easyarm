package com.example.easyframe.login;

import android.os.Bundle;
import android.view.View;

import com.example.easyframe.R;
import com.example.easyframe.mvp.CreatePresenter;
import com.example.easyframe.mvp.PresenterVariable;
import com.example.easyframe.mvp.base.EasyBaseMvpActivity;

/**
 * MVP 页面示例：展示 Presenter 的注解创建、字段注入，以及 View 回调。
 */
@CreatePresenter(presenter = {LoginPresenter.class})
public class LoginActivity extends EasyBaseMvpActivity<LoginPresenter> implements LoginView {

    @PresenterVariable
    private LoginPresenter presenter;

    @Override
    public void initView(Bundle savedInstanceState) {
        // 布局初始化完成后，Presenter 已由 EasyBaseMvpActivity 注入。
    }

    @Override
    public void initListener() {
        findViewById(R.id.btn_login_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getLogin();
            }
        });
    }

    @Override
    public void initData() {
        // 当前示例不请求真实接口，点击按钮后由 Model 立即返回成功。
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.testb;
    }

    @Override
    public void loginSuccess() {
        showToast(R.string.demo_mvp_login_success);
    }
}
