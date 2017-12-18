package com.example.administrator.animatortest.valueAnimator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/12/18 0018.
 */

public class MyValueAnimView extends View {

    public static final float RADIUS = 50f;
    private Point mCurrentPoint;
    private Paint mPaint;

    public MyValueAnimView(Context context) {
        this(context,null);
    }

    public MyValueAnimView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyValueAnimView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurrentPoint == null) {
            mCurrentPoint = new Point(RADIUS,RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = mCurrentPoint.getX();
        float y = mCurrentPoint.getY();
        canvas.drawCircle(x,y,RADIUS,mPaint);
    }

    private void startAnimation() {
        Point startPoint = new Point(getWidth()/2,RADIUS);
        Point endPoint = new Point(getWidth()/2,getHeight()-RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), startPoint,endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(3000);
        animator.setInterpolator(new DecelerateAccelarateInterpolator());
        animator.start();
    }

}
