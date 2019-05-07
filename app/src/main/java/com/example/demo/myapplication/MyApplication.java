package com.example.demo.myapplication;

import android.app.Application;

import com.example.demo.myapplication.bean.User;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }


    public boolean isLogin() {
       return isLogin;
    }

    private boolean isLogin = false;

    public void setLogin(Boolean bool) {
        isLogin = bool;
    }
    private User user = null;
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){
        return user;
    }
}
