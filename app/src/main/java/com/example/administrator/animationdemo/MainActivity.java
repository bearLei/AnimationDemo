package com.example.administrator.animationdemo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.FrameMetricsAggregator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button animation_frame,animation_tween,animaton_attribute;
    private Button testInterPalator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation_frame = findViewById(R.id.frame_animation);
        animation_tween = findViewById(R.id.tween_animation);
        animaton_attribute = findViewById(R.id.attribute_animation);
        testInterPalator = findViewById(R.id.test_interpolator);

        animation_frame.setOnClickListener(this);
        animation_tween.setOnClickListener(this);
        animaton_attribute.setOnClickListener(this);
        testInterPalator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frame_animation:
                startActivity(new Intent(this,FrameActivity.class));
                break;
            case R.id.tween_animation:
                startActivity(new Intent(this,TweenActivity.class));
                break;
            case R.id.attribute_animation:
                startActivity(new Intent(this,AttributeActivity.class));
                break;
            case R.id.test_interpolator:
                startActivity(new Intent(this,InterpalatorActivity.class));
                break;

        }
    }
}
