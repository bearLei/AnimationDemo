package com.example.administrator.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ValueAnimatorActivity extends Activity implements View.OnClickListener {
    private Button start,mTarget,testBasic01,testBasic02,testBasic03;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_animator_activity);
        start = findViewById(R.id.start_animation);
        mTarget = findViewById(R.id.target);
        testBasic01 = findViewById(R.id.test_basic01);
        testBasic02 = findViewById(R.id.test_basic02);
        testBasic03 = findViewById(R.id.test_basic03);

        testBasic01.setOnClickListener(this);
        testBasic02.setOnClickListener(this);
        testBasic03.setOnClickListener(this);
        start.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_basic01:
                testBasic01();
                break;
            case R.id.test_basic02:
                loadAnimationFromXml();
                break;
            case R.id.test_basic03:
                gradientColor();
                break;
            case R.id.start:

                break;
        }
    }

    /**
     * 基础1：测试ValueAnimator 的属性改变
     */
    private void testBasic01(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,10);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(5);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.d("lei", (Integer)animation.getAnimatedValue()+"");
            }
        });
        valueAnimator.start();
    }

    /**
     * xml中加载动画,动态修改Button宽度
     */
    private void loadAnimationFromXml(){
        ValueAnimator animator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.animator_01);
        animator.setTarget(mTarget);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer animatedValue = (Integer) animation.getAnimatedValue();
                mTarget.getLayoutParams().width = animatedValue;
                mTarget.requestLayout();
            }
        });
        animator.start();
    }

    /**
     * 颜色渐变   ValueAnimator.offArgb
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void gradientColor(){
        ValueAnimator valueAnimator = ValueAnimator.ofArgb(0x4577dc, 0xffff00ff, 0x33333333);
        valueAnimator.setDuration(3000);
        valueAnimator.setTarget(mTarget);
        valueAnimator.setRepeatCount(10);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer animatedValue = (Integer) animation.getAnimatedValue();
                Log.d("lei",animatedValue+"");
                mTarget.setBackgroundColor(animatedValue);
            }
        });
        valueAnimator.start();
    }


    /**
     * 动画1：动态改变Button的宽
     */
    private void changeWidth(){

    }

}
