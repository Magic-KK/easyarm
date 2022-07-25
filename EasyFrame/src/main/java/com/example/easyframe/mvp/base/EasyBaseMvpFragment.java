package com.example.easyframe.mvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.easyframe.base.EasyBaseFragment;
import com.example.easyframe.mvp.PresenterDispatch;
import com.example.easyframe.mvp.PresenterProviders;
import com.example.easyframe.mvp.intef.IBaseView;

public abstract class EasyBaseMvpFragment<P extends BasePresenter> extends EasyBaseFragment implements IBaseView {
    private PresenterProviders mPresenterProviders;
    private PresenterDispatch mPresenterDispatch;
    protected Context mContext;
    protected Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenterProviders=PresenterProviders.inject(this);
        mPresenterDispatch=new PresenterDispatch(mPresenterProviders);
        mPresenterDispatch.attachView(getActivity(), this);
        mPresenterDispatch.onCreatePresenter(savedInstanceState);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getContext();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenterDispatch.onSaveInstanceState(outState);
    }

    protected P getPresenter() {
        return mPresenterProviders.getPresenter(0);
    }

    public PresenterProviders getPresenterProviders() {
        return mPresenterProviders;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismiss() {

    }

    @Override
    public void loadEmpty(int type, String content) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenterDispatch.detachView();
    }

    @Override
    public void onDetach() {
        if (null != this.mActivity) {
            this.mActivity=null;
        }
        super.onDetach();
    }
}
