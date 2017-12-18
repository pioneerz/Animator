package com.example.administrator.animatortest.valueAnimator;

import android.animation.TimeInterpolator;

/**
 * Created by Administrator on 2017/12/18 0018.
 */

public class DecelerateAccelarateInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        float result;
        if (input <= 0.5) {
            result = (float) (Math.sin(Math.PI * input)) / 2;
        } else {
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }
        return result;
    }
}
