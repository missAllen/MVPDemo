package com.example.seele.model;

import com.example.seele.bean.UserInfoBean;
import com.example.seele.interfaces.listener.OnLoginListener;
import com.example.seele.interfaces.mobel.IUserLoginMobel;

/**
 * Created by SEELE on 2017/11/20.
 */

public class UserLoginModel implements IUserLoginMobel {
    @Override
    public void login(final String name, final String pwd, final OnLoginListener loginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    if ("admin".equals(name) && "admin".equals(pwd)) {
                        UserInfoBean userInfoBean = new UserInfoBean();
                        userInfoBean.setUserId(System.currentTimeMillis());
                        userInfoBean.setUserName(name);
                        userInfoBean.setUserPwd(pwd);
                        loginListener.loginSuccess(userInfoBean);
                    } else {
                        loginListener.loginFailed("密码错误");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
