package com.example.jadwal_praktek_rumah_sakit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;
    private Context mContext;
    private int PRIVATE_MODE;
    private static final String PREF_NAME = "SharedPrefLogin";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NAMA = "nama";
    @SuppressLint("CommitPrefEdits")
    SessionManager(Context mContext) {
        this.mContext = mContext;
        mSharedPreference =
                this.mContext.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }
    void createLoginSession(String username, String nama){
        mEditor.putBoolean(IS_LOGIN,true);
        mEditor.putString(KEY_USERNAME,username);
        mEditor.putString(KEY_NAMA,nama);
        mEditor.commit();
    }
    boolean isLoggedIn(){
        return mSharedPreference.getBoolean(IS_LOGIN,false);
    }
    public void checkIsLogin(){
        if(!isLoggedIn()){
            Intent i = new Intent(mContext, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }
    void logoutUser(){
        mEditor.clear();
        mEditor.commit();
        Intent i = new Intent(mContext,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
    String getNama(){
        return mSharedPreference.getString("nama",null);
    }
}
