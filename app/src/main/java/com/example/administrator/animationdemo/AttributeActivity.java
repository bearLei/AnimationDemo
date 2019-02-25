package com.example.administrator.animationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AttributeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attribute_activity);
        findViewById(R.id.value_animator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AttributeActivity.this,ValueAnimatorActivity.class));
            }
        });


        findViewById(R.id.object_animator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AttributeActivity.this,ObjectAnimatorActivity.class));
            }
        });


    }
}
