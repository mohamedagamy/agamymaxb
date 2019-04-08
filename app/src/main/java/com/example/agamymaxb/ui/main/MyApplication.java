package com.example.agamymaxb.ui.main;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

public class MyApplication extends Application {
    public static MyApplication INSTANCE;
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        context = this;
    }

    // singleton
    public static MyApplication getInstance(){
        if(INSTANCE == null)
            INSTANCE = new MyApplication();

        return INSTANCE;
    }

    public static Context getContext() {
        return context;
    }
}
