package com.fs.flacsound.application;

import android.app.Application;

/**
 * Created by KuNn on 2016/11/25.
 */

public class MainApplication extends Application {


    private static MainApplication singleton;

    public static MainApplication getInstance(){
        return singleton;
    }

    @Override public void onCreate() {
        super.onCreate();
        singleton=this;
       /*if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        // Normal app init code...*/
    }
}
