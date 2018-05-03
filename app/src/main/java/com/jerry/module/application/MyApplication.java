package com.jerry.module.application;

import android.app.Application;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/5/3
 * Time: 14:23
 * Description:
 */
public class MyApplication extends Application {

    private static MyApplication sApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static MyApplication getInstance() {
        return sApplication;
    }
}
