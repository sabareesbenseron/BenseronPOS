
package com.example.saku1.benseronemv.Activity;

import android.support.multidex.MultiDexApplication;

import com.example.saku1.benseronemv.Controller.CategoryController;
import com.example.saku1.benseronemv.Controller.OrderController;

/**
 * Created by saku1 on 3/12/2017.
 */

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        CategoryController.getInstance();
        OrderController.getInstance();
    }
}