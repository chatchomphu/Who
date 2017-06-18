package com.project.mobileapp.game;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.ArrayList;

public class Countdown extends AppCompatActivity {
    private ArrayList<String> friendList;
    private AnimationDrawable mAnimation;
    private static final long interval = 3000;
    private Handler handler = new Handler();
    private String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        value = getIntent().getStringExtra("situation");

        ImageView img = (ImageView)findViewById(R.id.imageView);
        BitmapDrawable[] frame = new BitmapDrawable[4];


        for(int i=3; i>=1; i--){
            frame[i] = (BitmapDrawable)getResources().getDrawable(getResources().getIdentifier((String)"s"+i, "drawable",Countdown.this.getPackageName()));
        }
        int reasonableDuration = 1000;
        mAnimation = new AnimationDrawable();
        for(int i=3; i>=1; i--){
            mAnimation.addFrame(frame[i], reasonableDuration);
        }
        img.setImageDrawable(mAnimation);

        ScaleAnimation sAnimation = new ScaleAnimation(1f,1f,1f,1f, Animation.RELATIVE_TO_SELF,1f,Animation.RELATIVE_TO_SELF,1f);
        sAnimation.setDuration(1000);
        sAnimation.setFillAfter(true);
        sAnimation.setRepeatCount(Animation.INFINITE);
        sAnimation.setRepeatMode(Animation.REVERSE);
        img.setAnimation(sAnimation);
        mAnimation.start();
        mAnimation.setOneShot(true);
        handler.postDelayed(countdown,interval);


    }

    private  Runnable countdown = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Countdown.this,Situation.class);
            intent.putExtra("situation",value);
            startActivity(intent);
        }
    };
}
