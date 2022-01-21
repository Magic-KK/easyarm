package com.example.easyframe.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.easyframe.toolmodel.EasyToast;
import com.example.easyframe.view.EasyProgressDialog;

public abstract class EasyBaseFragment extends Fragment {

    protected View mRootView;
    private EasyProgressDialog mProgressDialog;
    protected boolean isDestroy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getFragmentLayoutId(), container, false);

            initView(mRootView);
            initListener(mRootView);
            initData(mRootView);
        } else {
            if (mRootView.getParent() != null) {
                ((ViewGroup) mRootView.getParent()).removeView(mRootView);
            }
        }
        return mRootView;
    }

    public abstract void initView(View view);

    public abstract void initListener(View view);
    
    public abstract void initData(View view);

    public abstract int getFragmentLayoutId();

    public void showToast(String text) {
        EasyToast.show(text);
    }

    public void showToast(int text) {
        EasyToast.show(text);
    }

    public void showProgress() {
        showProgress("");
    }

    public void showProgress(String title) {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            return;
        }
        mProgressDialog = new EasyProgressDialog(getContext());
        mProgressDialog.show();
        mProgressDialog.setTitle(title);
    }

    public void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()
                && !isDestroy) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }
}
