package com.example.administrator.animatortest.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/12/18 0018.
 */

public class ScreenUtils {

    public static int getWindowHeight(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
//        int width2 = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        return height;
    }

}
