package com.yzb.serial.app;

import android.content.Context;


import android.app.Application;

public class SerialApplication extends Application {

    public static String PWD = "";
    public static String URL = "";
    public static String USER_NAME = "";
    public static int LOCK_STATUS = 0;
    public static int UNLOCK_STATUS = 0;


    public static boolean isOnAppStore = false;

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }


    /**
     * 获取全局上下文对象
     *
     * @return
     */
    public static Context getAppContext() {
        return context;
    }
}
