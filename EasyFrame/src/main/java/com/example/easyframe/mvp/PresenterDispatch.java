package com.example.easyframe.mvp;

import android.content.Context;
import android.os.Bundle;


import androidx.annotation.Nullable;

import com.example.easyframe.mvp.base.BasePresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * @name zk
 * @class name：
 * @time 2018-08-24 上午 11:33
 */
public class PresenterDispatch {
    private PresenterProviders mProviders;

    public PresenterDispatch(PresenterProviders providers) {
        mProviders=providers;
    }

    public <P extends BasePresenter> void attachView(Context context, Object view) {
        PresenterStore store=mProviders.getPresenterStore();
        HashMap<String, P> mMap=store.getMap();
        for (Map.Entry<String, P> entry : mMap.entrySet()) {
            P presenter=entry.getValue();
            if (presenter != null) {
                presenter.attachView(context, view);
            }
        }
    }

    public <P extends BasePresenter> void detachView() {
        PresenterStore store=mProviders.getPresenterStore();
        HashMap<String, P> mMap=store.getMap();
        for (Map.Entry<String, P> entry : mMap.entrySet()) {
            P presenter=entry.getValue();
            if (presenter != null) {
                presenter.detachView();
            }
        }
    }

    public <P extends BasePresenter> void onCreatePresenter(@Nullable Bundle savedState) {
        PresenterStore store=mProviders.getPresenterStore();
        HashMap<String, P> mMap=store.getMap();
        for (Map.Entry<String, P> entry : mMap.entrySet()) {
            P presenter=entry.getValue();
            if (presenter != null) {
                presenter.onCreatePresenter(savedState);
            }
        }
    }

    public <P extends BasePresenter> void onDestroyPresenter() {
        PresenterStore store=mProviders.getPresenterStore();
        HashMap<String, P> mMap=store.getMap();
        for (Map.Entry<String, P> entry : mMap.entrySet()) {
            P presenter=entry.getValue();
            if (presenter != null) {
                presenter.onDestroyPresenter();
            }
        }
    }

    public <P extends BasePresenter> void onSaveInstanceState(Bundle outState) {
        PresenterStore store=mProviders.getPresenterStore();
        HashMap<String, P> mMap=store.getMap();
        for (Map.Entry<String, P> entry : mMap.entrySet()) {
            P presenter=entry.getValue();
            if (presenter != null) {
                presenter.onSaveInstanceState(outState);
            }
        }
    }
}
