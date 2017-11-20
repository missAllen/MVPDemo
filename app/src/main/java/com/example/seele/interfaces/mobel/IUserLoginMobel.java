package com.example.seele.interfaces.mobel;

import com.example.seele.interfaces.listener.OnLoginListener;

/**
 * Created by SEELE on 2017/11/20.
 */

public interface IUserLoginMobel extends IBaseMobel {
    void login(String name, String pwd, OnLoginListener loginListener);
}
