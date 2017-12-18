package com.example.administrator.animatortest.propertyanimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.animatortest.CircleView;
import com.example.administrator.animatortest.R;

/**
 * Created by Administrator on 2017/12/15 0015.
 * tween动画针对view，属性动画针对属性
 */

public class PropertyAnimatorActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "PropertyAnimator";

    private Button mValueAnimButton;
    private Button mObjectAnimButton;
    private Button mViewPropertyAnimButton;
    private Button mAnimSetButton;
    private CircleView mCircleView;
    private boolean mFlag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animator);
        initView();
    }

    private void initView() {
        mValueAnimButton = (Button) findViewById(R.id.button_property_value);
        mValueAnimButton.setOnClickListener(this);
        mObjectAnimButton = (Button) findViewById(R.id.button_property_object);
        mObjectAnimButton.setOnClickListener(this);
        mViewPropertyAnimButton = (Button) findViewById(R.id.button_property_view);
        mViewPropertyAnimButton.setOnClickListener(this);
        mAnimSetButton = (Button) findViewById(R.id.button_property_set);
        mAnimSetButton.setOnClickListener(this);
        mCircleView = (CircleView) findViewById(R.id.circle_view);
    }

    @Override
    public void onClick(View v) {
        if (v == mValueAnimButton) {
            startValueAnimation();
        } else if (v == mViewPropertyAnimButton) {
            startViewPropertyAnimation();
        } else if (v == mObjectAnimButton) {
            startObjectAnimation();
        } else if (v == mAnimSetButton) {
            startAnimatorSet();
        }
    }

    private void startAnimatorSet() {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofInt(mCircleView,"color",0xffff0000,0xff0000ff);
        animator1.setEvaluator(new ArgbEvaluator());
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mCircleView,"scaleY",1.4f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mCircleView,"scaleX",1.4f);
//        set.playSequentially(animator1,animator2,animator3);
        set.play(animator1).after(animator2).before(animator3);
        set.setDuration(2000);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(PropertyAnimatorActivity.this,"end!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void startObjectAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofInt(mCircleView,"color",0xffff0000,0xff00ff00);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setDuration(2000);
        animator.start();
    }

    private void startViewPropertyAnimation() {
        final ViewPropertyAnimator animate = mCircleView.animate();
        if (!mFlag) {
            animate.alpha(0.5f)
                    .scaleY(2f)
                    .scaleX(2f)
                    .setDuration(2000);
        } else {
            animate.alpha(1)
                    .scaleY(1f)
                    .scaleX(1f)
                    .setDuration(2000);
        }
        mFlag = !mFlag;
    }

    private void startValueAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1.0f);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.e(TAG,"value = " + currentValue);
            }
        });
        animator.start();
    }
}
