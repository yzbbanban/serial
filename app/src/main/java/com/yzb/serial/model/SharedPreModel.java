package com.yzb.serial.model;

import android.content.Context;
import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yzb.serial.entity.ApiInfo;
import com.yzb.serial.entity.Bucket;
import com.yzb.serial.entity.User;

import java.util.List;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreModel {

    private static final String TAG = "SharedPreModel";

    /**
     * 保存用户
     *
     * @param name     用户
     * @param password 密码
     */
    public static void saveUserSp(Context context, String name, String password) {
        SharedPreferences.Editor editor = context.getSharedPreferences("user", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.putString("password", password);
        editor.commit();
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    public static User getUserSp(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("user", MODE_PRIVATE);
        String name = preferences.getString("name", "");
        String password = preferences.getString("password", "");
        User user = new User(name, password);
        return user;
    }

    /**
     * 保存api 信息
     *
     * @param ip 用户
     * @param ip 密码
     */
    public static void saveApiSp(Context context, String ip) {
        SharedPreferences.Editor editor = context.getSharedPreferences("api", MODE_PRIVATE).edit();
        editor.putString("ip", ip);
        editor.commit();
    }

    /**
     * 获取 api 信息
     *
     * @return api 信息
     */
    public static ApiInfo getAPiSp(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("api", MODE_PRIVATE);
        String ip = preferences.getString("ip", "");
        String url = preferences.getString("url", "");
        ApiInfo apiInfo = new ApiInfo(ip, url);
        return apiInfo;
    }

    /**
     * 保存bucket 信息
     *
     * @param context    context
     * @param bucketList bucketList
     */
    public static void saveBucket(Context context, String bucketList) {
        SharedPreferences.Editor editor = context.getSharedPreferences("bucket", MODE_PRIVATE).edit();
        editor.putString("bucket", bucketList);
        editor.commit();
    }

    /**
     * 获取 bucket 信息
     *
     * @return bucket 信息
     */
    public static List<Bucket> getBucket(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("bucket", MODE_PRIVATE);
        String buckets = preferences.getString("bucket", "");

        List<Bucket> bucketList = new Gson().fromJson(buckets, new TypeToken<List<Bucket>>() {
        }.getType());
        if (bucketList == null) {
            return new ArrayList<>();
        }
        return bucketList;
    }

}
