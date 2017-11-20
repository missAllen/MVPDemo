package com.example.seele.interfaces.view;

import com.example.seele.bean.UserInfoBean;

/**
 * Created by SEELE on 2017/11/20.
 */

public interface IUserLoginView {
    //获得用户信息
    String getUserName();

    String getPassword();

    //清除用户信息
    void clearUserName();

    void clearPassword();

    //遮罩层
    void showLoading();

    void hideLoading();

    //登陆成功
    void toMainActivity(UserInfoBean user);

    //登陆失败
    void showFailedError(String message);
}
