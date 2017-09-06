package com.btsy.wehelp;

import android.app.Application;
import android.content.ComponentCallbacks;

import com.droi.sdk.core.Core;

/**
 * Created by zhouzhongbo on 2017/6/26.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Core.initialize(this);
    }


    @Override
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        super.registerComponentCallbacks(callback);
    }


}
