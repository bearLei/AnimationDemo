package com.example.administrator.animationdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class InterpalatorActivity extends Activity {

    private ImageView target;
    private Button start;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interpalator_activity);
        target = findViewById(R.id.target);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator =
                        ObjectAnimator.ofFloat(target,"translationX",0,500);
                animator.setDuration(3000);
                animator.setRepeatMode(ValueAnimator.REVERSE);
//                animator.setRepeatCount(5);
                animator.setInterpolator(new CustomInterpolator01());
                animator.start();
            }
        });
    }
}
