package com.teb.kos.kosovakurumsal.app;

import android.app.Application;
import android.content.Context;

import service.di.AppComponent;
import service.di.DaggerAppComponent;

import service.retrofit.RetrofitService;

/**
 * Created by mobile on 4.06.2018.
 */

public class AppController extends Application {
    private static AppComponent appComponent;

    private static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    public static AppController create(Context context) {
        return AppController.get(context);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    public AppComponent buildAppComponent() {
        return DaggerAppComponent.builder().retrofitService(new RetrofitService()).build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
