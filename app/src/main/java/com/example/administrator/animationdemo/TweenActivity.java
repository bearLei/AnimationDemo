package com.example.administrator.animationdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.animationdemo.customView.Rotate3dAnimation;

public class TweenActivity extends Activity implements View.OnClickListener {

    private Button scale,rorate,translate,alpha;
    private View anmationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween_activity);
        scale = findViewById(R.id.scale);
        rorate = findViewById(R.id.rotate);
        translate = findViewById(R.id.translate);
        alpha = findViewById(R.id.alpha);

        anmationView = findViewById(R.id.animation_view);

       scale.setOnClickListener(this);
       rorate.setOnClickListener(this);
       translate.setOnClickListener(this);
       alpha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scale:
//                Animation animation = AnimationUtils.loadAnimation(this,R.anim.tween_scale);
//                anmationView.startAnimation(animation);
                ScaleAnimation animation = new ScaleAnimation(1.0f,0.5f,1.0f,0.5f,0f,0f);
                animation.setDuration(2000);
                anmationView.startAnimation(animation);
                break;
            case R.id.rotate:
//                Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.tween_rotate);
//                anmationView.startAnimation(animation3);
//                RotateAnimation rotateAnimation = new RotateAnimation()
                Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(0,360,0,0,0,true);
                rotate3dAnimation.setDuration(2000);
                rotate3dAnimation.setRepeatCount(10);
                rotate3dAnimation.setFillAfter(true);
                anmationView.startAnimation(rotate3dAnimation);
                break;
            case R.id.translate:
//                Animation animation1 = AnimationUtils.loadAnimation(this,R.anim.tween_translate);
//                anmationView.startAnimation(animation1);
                TranslateAnimation translateAnimation = new TranslateAnimation(100,100,300,300);
                anmationView.startAnimation(translateAnimation);
                break;
            case R.id.alpha:
//                Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.tween_alpha);
//                anmationView.startAnimation(animation2);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.0f);
                anmationView.startAnimation(alphaAnimation);
                break;
        }
    }
}
