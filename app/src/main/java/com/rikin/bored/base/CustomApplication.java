package com.rikin.bored.base;

import android.app.Application;

import com.rikin.bored.dagger.DaggerSingletonComponent;
import com.rikin.bored.dagger.SingletonComponent;

public class CustomApplication extends Application {

    private SingletonComponent singletonComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        singletonComponent = DaggerSingletonComponent.create();
    }

    public SingletonComponent getSingletonComponent() {
        return singletonComponent;
    }
}
