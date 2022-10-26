package com.example.pos_android.data.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String TAG = SessionManager.class.getSimpleName();

    private final SharedPreferences sharedPref;
    private final SharedPreferences.Editor editor;
    Context context;
    private static final String PREF_NAME = "pos_android";
    private static final String IS_LOGGED_IN = "isLoggedIn";
    private static final String USERID = "userId";
    private static final String USERNAME = "userName";

    public SessionManager(Context context) {
        this.context = context;
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void setLogin(boolean isLoggedIn) {
        editor.putBoolean(IS_LOGGED_IN, isLoggedIn);
        editor.apply();
    }

    public void setUserId(String name) {
        editor.putString(USERID, name);
        editor.apply();
    }

    public void setUserName(String name) {
        editor.putString(USERNAME, name);
        editor.apply();
    }


    public boolean isLoggedIn() {
        return sharedPref.getBoolean(IS_LOGGED_IN, false);
    }

    public String getUserId() {
        return sharedPref.getString(USERID, "");
    }

    public String getUserName() {
        return sharedPref.getString(USERNAME, "");
    }

    public void clear() {
        editor.clear();
        editor.apply();
    }
}

