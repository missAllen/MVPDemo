package com.example.seele.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.seele.presenter.BasePresenter;

/**
 * Created by SEELE on 2017/11/20.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    public abstract T initPresenter();

    public T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(setMvcView());
        presenter = initPresenter();
        initView();
    }

    protected abstract int setMvcView();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
