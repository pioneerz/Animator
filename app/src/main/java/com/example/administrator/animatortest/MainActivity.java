package com.example.administrator.animatortest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mViewAnimatorButton;
    private Button mPropertyAnimatorButton;
    private Button mValuePropertyAnimButton;
    private static final String VIEW_ANIMATOR_ACTION = "com.example.administrator.animatortest.viewanimator";
    private static final String PROPERTY_ANIMATOR_ACTION = "com.example.administrator.animatortest.propertyanimator.propertyanimatoractivity";
    private static final String VALUE_ANIMATOR_ACTION = "com.example.administrator.animatortest.valueAnimator.valueanimactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mViewAnimatorButton = (Button) findViewById(R.id.view_animator);
        mPropertyAnimatorButton = (Button) findViewById(R.id.property_animator);
        mValuePropertyAnimButton = (Button) findViewById(R.id.value_animator);
        mViewAnimatorButton.setOnClickListener(this);
        mPropertyAnimatorButton.setOnClickListener(this);
        mValuePropertyAnimButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {
            Intent intent = new Intent();
            if (view == mViewAnimatorButton) {
                intent.setAction(VIEW_ANIMATOR_ACTION);
            } else if (view == mPropertyAnimatorButton) {
                intent.setAction(PROPERTY_ANIMATOR_ACTION);
            } else if (view == mValuePropertyAnimButton) {
                intent.setAction(VALUE_ANIMATOR_ACTION);
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.e("author","error = " + e.getMessage());
        }
    }
}
