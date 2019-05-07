package com.example.demo.myapplication.activity;

import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.example.demo.myapplication.R;
import com.example.demo.myapplication.base.BaseActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {


    @BindView(R.id.iv_splash)
    AppCompatImageView ivSplash;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
      //  ScaleAnimation scaleAnimation=new ScaleAnimation();
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.3f,1.0f);
        alphaAnimation.setDuration(2000);
        ivSplash.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }



}
