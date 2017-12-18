package com.example.administrator.animatortest.viewanimatior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.administrator.animatortest.CircleView;
import com.example.administrator.animatortest.R;

/**
 * Created by Administrator on 2017/12/15 0015.
 */

public class ViewAnimatorActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "ViewAnimator";

    private Button mAlphaButton;
    private Button mTranslateButton;
    private Button mScaleButton;
    private Button mRotateButton;
    private Button mAnimationSet;

    private CircleView mCircleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_animator);
        initView();
        initListener();
    }

    private void initListener() {
        mScaleButton.setOnClickListener(this);
        mRotateButton.setOnClickListener(this);
        mTranslateButton.setOnClickListener(this);
        mAlphaButton.setOnClickListener(this);
        mAnimationSet.setOnClickListener(this);
    }

    private void initView() {
        mCircleView = (CircleView) findViewById(R.id.custom_view);
        mAlphaButton = (Button) findViewById(R.id.button_view_alpha);
        mScaleButton = (Button) findViewById(R.id.button_view_scale);
        mRotateButton = (Button) findViewById(R.id.button_view_rotate);
        mAnimationSet = (Button) findViewById(R.id.button_view_set);
        mTranslateButton = (Button) findViewById(R.id.button_view_translate);
    }

    @Override
    public void onClick(View view) {
        Animation animation = null;
        if (view == mAlphaButton) {
            animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        } else if (view == mTranslateButton) {
            animation = AnimationUtils.loadAnimation(this,R.anim.translate);
        } else if (view == mRotateButton) {
            animation = AnimationUtils.loadAnimation(this,R.anim.rotate);
        } else if (view == mScaleButton) {
            animation = AnimationUtils.loadAnimation(this,R.anim.scale);
        } else if (view == mAnimationSet) {
            startAnimationSet();
        }
        if (animation != null) {
            mCircleView.startAnimation(animation);
        }
    }

    private void startAnimationSet() {
        AnimationSet set = new AnimationSet(false); // 注意AnimatorSet
        Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.alpha);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.translate);
//        Animation animation3 = AnimationUtils.loadAnimation(this,R.anim.rotate);
        Animation animation4 = AnimationUtils.loadAnimation(this,R.anim.scale);
        set.addAnimation(animation1);
        set.addAnimation(animation2);
//        set.addAnimation(animation3);
        set.addAnimation(animation4);
        mCircleView.startAnimation(set);
    }
}
