package com.example.administrator.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;

public class ObjectAnimatorActivity extends Activity implements View.OnClickListener {


    private Button changeAlpha,mTarget,rotate,translate,scale,animationSet;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_animator_activity);
        changeAlpha = findViewById(R.id.change_alpha);
        mTarget = findViewById(R.id.target);
        rotate = findViewById(R.id.rotate);
        translate = findViewById(R.id.translate);
        scale = findViewById(R.id.scale);
        animationSet = findViewById(R.id.animation_set);

        changeAlpha.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        scale.setOnClickListener(this);
        animationSet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_alpha:
                changeAlpha();
                break;
            case R.id.rotate:
                rotate();
                break;
            case R.id.translate:
                translate();
                break;
            case R.id.scale:
                scale();
                break;
            case R.id.animation_set:
                animationSet();
                break;
        }
    }

    /**
     * 改变Alpha值
     */
    @SuppressLint("ObjectAnimatorBinding")
    private void changeAlpha(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTarget,"alpha",1,0.25f);
        start(animator);
    }

    /**
     * 旋转
     */
    private void rotate(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTarget,"rotation",0f,360f);
        start(animator);

    }

    /**
     * 平移
     */
    private void translate(){
        float translationX =  mTarget.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTarget,"translationX",translationX,300,translationX);
        start(animator);
    }

    /**
     * 缩放
     */
    private void scale(){
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animator = ObjectAnimator.ofFloat(mTarget,"scaleX",1f,3f,1f);
        start(animator);
    }

    private void animationSet(){
        float translationX =  mTarget.getTranslationX();
        //alpha动画
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mTarget,"alpha",1,0.25f);
        //缩放动画
        ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(mTarget,"scaleX",1f,3f,1f);
        //平移动画
        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(mTarget,"translationX",translationX,300,translationX);
        //旋转动画
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(mTarget,"rotation",0f,360f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(translationXAnimator).with(alphaAnimator).with(scaleAnimator).with(rotationAnimator);
        animatorSet.setDuration(3000);
        animatorSet.start();
    }


    private void start(ObjectAnimator animator){
        animator.setDuration(3000);
        animator.setRepeatCount(10);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }
        });
        animator.start();
    }

}
