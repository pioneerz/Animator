package com.example.administrator.animatortest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/12/14 0014.
 */

public class CircleView extends View {

    private Context mContext;
    private Paint mPaint;
    private int color = 0;
    private float mWidth;
    private float mHeight;
    private float mRadius;
    private float mCx;
    private float mCy;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        invalidate();
    }

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs);
        mContext = context;
        initPaint();
    }

    private void getAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.custom);
        mWidth = ta.getDimension(R.styleable.custom_width, 10f);
        mHeight = ta.getDimension(R.styleable.custom_height, 10f);
        ta.recycle();

        Log.e("author","width = " + mWidth);
        Log.e("author","height = " + mHeight);

        float min = Math.min(mWidth,mHeight);
        mRadius = min/2;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        color = ContextCompat.getColor(mContext, R.color.color_start);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        mCx = width/2;
        mCy = height/2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(color);
        canvas.drawCircle(mCx,mCy,mRadius,mPaint);
    }
}
