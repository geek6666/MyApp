package com.zy.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.widget.VideoView;

public class MyActivity extends Activity implements SurfaceHolder.Callback {
    /**
     * Called when the activity is first created.
     */
    private VideoView mVideoView;

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
}
