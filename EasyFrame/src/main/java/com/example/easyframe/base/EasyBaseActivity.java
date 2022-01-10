package com.example.easyframe.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easyframe.toolmodel.EasyToast;
import com.example.easyframe.view.EasyProgressDialog;

/**
 * BaseActivity
 */
public abstract class EasyBaseActivity extends AppCompatActivity {

    private EasyProgressDialog mProgressDialog;
    protected boolean isDestroy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityLayoutId());
        initView(savedInstanceState);
        initListener();
        initData();
    }

    public abstract void initView(Bundle savedInstanceState);

    public abstract void initListener();

    public abstract void initData();

    public abstract int getActivityLayoutId();

    public void showProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            return;
        }
        mProgressDialog = new EasyProgressDialog(this);
        mProgressDialog.show();
    }

    public void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()
                && !isDestroy) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }

    public void showToast(String text) {
        EasyToast.show(text);
    }

    public void showToast(int text) {
        EasyToast.show(text);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
