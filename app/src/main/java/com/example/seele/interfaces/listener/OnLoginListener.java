package com.example.seele.interfaces.listener;

import com.example.seele.bean.UserInfoBean;

/**
 * Created by SEELE on 2017/11/20.
 */

public interface OnLoginListener {
    void loginSuccess(UserInfoBean user);

    void loginFailed(String message);
}
