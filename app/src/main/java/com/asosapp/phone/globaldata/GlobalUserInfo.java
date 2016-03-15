package com.asosapp.phone.globaldata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.asosapp.phone.activity.LoginActivity;

/**
 * Created by huibin on 15/7/20.
 */
public class GlobalUserInfo {

    private String user_id;
    private static GlobalUserInfo globalUserInfo;
    private boolean isLogin;
    private String user_name;//用户姓名
    private String user_sexy;//用户性别g
    private String user_phone;//用户电话号码
    private String user_age;//用户年龄
    private boolean is_push;//是否接收推送
    public static GlobalUserInfo getInstance() {
        if (globalUserInfo == null) {
            globalUserInfo = new GlobalUserInfo();
        }
        return globalUserInfo;
    }

    /**
     * 退出登录
     */
    public void logOut(Context context) {
        this.isLogin = false;
        this.user_id = "";
        this.user_name = "";
        this.user_sexy = "";
        this.user_phone = "";
        this.user_age = "";
        this.is_push = true;

        //保存到配置文件
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserInfo", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin", isLogin);
        editor.putString("user_id", user_id);
        editor.putString("user_name",user_name);
        editor.putString("user_sexy",user_sexy);
        editor.putString("user_phone",user_phone);
        editor.putString("user_age",user_age);
        editor.putBoolean("is_push", is_push);
        editor.commit();
    }
    /**
     * 根据当前登录状态，判断是否跳转登录界面
     *
     * @param context
     * @param resultCode
     * @return true 表示当前已经登录，不会跳转登录界面
     * false 表示会跳转登录页面
     */
    public boolean jumpByLoginState(Activity context, int resultCode) {
        if (!isLogin) {
            context.startActivityForResult(new Intent(context, LoginActivity.class), resultCode);
        }
        return isLogin;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sexy() {
        return user_sexy;
    }

    public void setUser_sexy(String user_nickname) {
        this.user_sexy = user_nickname;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_type) {
        this.user_age = user_type;
    }

    public Boolean getIs_push() {
        return is_push;
    }

    public void setIs_push(Boolean is_push) {
        this.is_push = is_push;
    }

}
