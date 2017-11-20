package com.example.seele.presenter;

/**
 * Created by SEELE on 2017/11/20.
 */

public class BasePresenter<T> {
    protected T mvcView;

    /**
     * 每个继承基类的presenter都要去实现构造方法，并传入view层
     */
    protected BasePresenter(T mvcView) {
        this.mvcView = mvcView;
    }

    /**
     * 因为presenter层持有view层，所以，提供一个方法，在view层不使用的时候将对象释放
     */
    public void onDestroy() {
        mvcView = null;
    }
}
