package com.zy.myapp.utils;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.zy.myapp.R;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by Administrator on 2015/3/3.
 */
public class PlayActivity extends Activity {
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_play);

//        List<Video> videos = MediaUtil.newInstance().searchVoid(this);
        mVideoView = (VideoView) findViewById(R.id.videoview);
        mVideoView.setVideoURI(Uri.parse("http://www.modrails.com/videos/passenger_nginx.mov"));
//        mVideoView.setVideoPath(videos.get(0).path);

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
//                mp.setPlaybackSpeed(1.0f);
                mVideoView.start();
            }
        });
        mVideoView.setMediaController(new MediaController(this));


    }
}
