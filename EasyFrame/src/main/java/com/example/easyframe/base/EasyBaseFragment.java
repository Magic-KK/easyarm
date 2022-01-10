package com.example.easyframe.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.easyframe.toolmodel.EasyToast;

public abstract class EasyBaseFragment extends Fragment {

    protected View mRootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getFragmentLayoutId(), container, false);

            initView(mRootView);
            initData();
        } else {
            if (mRootView.getParent() != null) {
                ((ViewGroup) mRootView.getParent()).removeView(mRootView);
            }
        }

        return mRootView;
    }

    public abstract void initView(View view);

    public abstract void initData();

    public abstract int getFragmentLayoutId();

    public void showToast(String text) {
        EasyToast.show(text);
    }

    public void showToast(int text) {
        EasyToast.show(text);
    }

}
