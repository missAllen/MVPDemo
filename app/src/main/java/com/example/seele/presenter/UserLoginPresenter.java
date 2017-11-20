package com.example.seele.presenter;

import android.os.Handler;

import com.example.seele.bean.UserInfoBean;
import com.example.seele.interfaces.listener.OnLoginListener;
import com.example.seele.interfaces.mobel.IUserLoginMobel;
import com.example.seele.interfaces.view.IUserLoginView;
import com.example.seele.model.UserLoginModel;

/**
 * Created by SEELE on 2017/11/20.
 */

public class UserLoginPresenter extends BasePresenter<IUserLoginView> {
    protected IUserLoginView mvcView;//view的接口
    private IUserLoginMobel userLoginMobel;//mobel的接口
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        super(userLoginView);
        this.userLoginMobel = new UserLoginModel();//实例化用户登录业务层
    }

    public void login() {
        mvcView.showLoading();
        userLoginMobel.login(mvcView.getUserName(), mvcView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final UserInfoBean user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvcView.toMainActivity(user);
                        mvcView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed(final String message) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvcView.showFailedError(message);
                        mvcView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear() {
        mvcView.clearPassword();
        mvcView.clearUserName();
    }
}
