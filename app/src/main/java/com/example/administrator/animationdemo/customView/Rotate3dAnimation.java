package com.example.administrator.animationdemo.customView;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {


    private final float mFromDegrees;
    private final float mToDegrees;
    private final float mCenterX;
    private final float mCenterY;
    private final float mCenterZ;
    private final boolean mReverse;
    private Camera mCamera;

    public Rotate3dAnimation(float mFromDegrees, float mToDegrees, float mCenterX, float mCenterY, float mCenterZ, boolean mReverse) {
        this.mFromDegrees = mFromDegrees;
        this.mToDegrees = mToDegrees;
        this.mCenterX = mCenterX;
        this.mCenterY = mCenterY;
        this.mCenterZ = mCenterZ;
        this.mReverse = mReverse;
    }


    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        final  float fromDegrees = mFromDegrees;
        float degrees = fromDegrees +((mToDegrees - fromDegrees) * interpolatedTime);
        final  float centerX = mCenterX;
        final float centerY = mCenterY;
        final Camera camera = mCamera;
        Matrix matrix = t.getMatrix();
        camera.save();
        if (mReverse){
            camera.translate(0.0f,0.0f,mCenterZ * interpolatedTime);
        }else {
            camera.translate(0.0f,0.0f,mCenterZ *(1.0f-interpolatedTime));
        }

        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-mCenterX,-mCenterY);
        matrix.postTranslate(centerX,centerY);
    }
}
