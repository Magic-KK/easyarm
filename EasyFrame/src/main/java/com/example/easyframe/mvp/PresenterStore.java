package com.example.easyframe.mvp;



import com.example.easyframe.mvp.base.BasePresenter;

import java.util.HashMap;

/**
 * @name zk
 * @class name：
 * @time 2018-08-24 上午 11:33
 */
public class PresenterStore<P extends BasePresenter> {

    private static final String DEFAULT_KEY="PresenterStore.DefaultKey";
    private HashMap<String, P> mMap=new HashMap<>();

    public final void put(String key, P presenter) {
        P oldPresenter=mMap.put(DEFAULT_KEY + ":" + key, presenter);
        if (oldPresenter != null) {
            oldPresenter.onCleared();
        }
    }

    public final P get(String key) {
        return mMap.get(DEFAULT_KEY + ":" + key);
    }

    public final void clear() {
        for (P presenter : mMap.values()) {
            presenter.onCleared();
        }
        mMap.clear();
    }

    public int getSize() {
        return mMap.size();
    }

    public HashMap<String, P> getMap() {
        return mMap;
    }
}
