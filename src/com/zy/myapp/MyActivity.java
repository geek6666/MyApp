package com.zy.myapp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.VideoView;

public class MyActivity extends Activity implements SurfaceHolder.Callback, View.OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private VideoView mVideoView;
    private LinearLayout mContentLinearLayout;
    private View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
//            return;

        //获取默认的SP
//        PreferenceManager.getDefaultSharedPreferences(this);

//        List<Video> videos = MediaUtil.newInstance().searchVoid(this);
//        System.out.println(videos);

//        List<Image> images = MediaUtil.newInstance().searchImages(this);
//        System.out.println(images);


//        mVideoView = (VideoView) findViewById(R.id.video_view);
//        mVideoView.setVideoPath(videos.get(0).path);
//        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mVideoView.start();
//            }
//        });
//        mVideoView.setMediaController(new MediaController(this));//设置播放控制器


//        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
//        layoutParams.alpha = 0.5f;
        Button button = (Button) findViewById(R.id.button);
        mContentLinearLayout = (LinearLayout) findViewById(R.id.content);
        view = findViewById(R.id.view);
        button.setOnClickListener(this);
        view.setOnClickListener(this);

    }

    private void init() {
//        SurfaceView mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);
//        SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
//        mSurfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                buttonClick();
                break;
            case R.id.view:
                dismiss();
                break;
        }
    }

    private void buttonClick() {
        if (mContentLinearLayout.getVisibility() == View.GONE) {
            visible();
        } else {
            dismiss();
        }
    }

    public void visible() {
        mContentLinearLayout.setVisibility(View.VISIBLE);
        view.setVisibility(View.VISIBLE);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mContentLinearLayout, View.SCALE_Y, 0, 1);
        objectAnimator.setDuration(300);
        mContentLinearLayout.setPivotX(0);
        mContentLinearLayout.setPivotY(0);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void dismiss() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mContentLinearLayout, View.SCALE_Y, 1, 0);
        objectAnimator.setDuration(300);
        mContentLinearLayout.setPivotX(0);
        mContentLinearLayout.setPivotY(0);
        objectAnimator.start();
        view.setVisibility(View.GONE);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mContentLinearLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
