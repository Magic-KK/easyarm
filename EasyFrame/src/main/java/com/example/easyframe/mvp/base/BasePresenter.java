package com.example.easyframe.mvp.base;

import android.content.Context;
import android.os.Bundle;


import androidx.annotation.Nullable;


/**
 * @name zk
 * @class name：presenter抽象类
 * @time 2018-08-24 上午 11:39
 */
public abstract class BasePresenter<V> {
    protected Context mContext;
    protected V mView;

    public void onCleared() {

    }

    public void attachView(Context context, V view) {
        this.mContext = context;
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

    public boolean isAttachView() {
        return this.mView != null;
    }

    public void onCreatePresenter(@Nullable Bundle savedState) {

    }

    public void onDestroyPresenter() {
        this.mContext = null;
        detachView();
    }

    public void onSaveInstanceState(Bundle outState) {

    }
}

