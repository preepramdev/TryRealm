package com.pram.realmtest;

import android.app.Application;

import io.realm.Realm;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /** Realm initial */
        Realm.init(getApplicationContext());
    }
}
