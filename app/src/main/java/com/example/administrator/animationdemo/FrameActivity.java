package com.example.administrator.animationdemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameActivity extends Activity {

    private Button starAnimation,stopAnimation;
    private ImageView showAnimation;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_activity);
        starAnimation = findViewById(R.id.start_animation);
        stopAnimation = findViewById(R.id.stop_animation);
        showAnimation = findViewById(R.id.frame_01);

        starAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable = (AnimationDrawable) showAnimation.getDrawable();
                animationDrawable.start();
            }
        });

        stopAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (animationDrawable != null){
                    animationDrawable.stop();
                }
            }
        });


    }
}
