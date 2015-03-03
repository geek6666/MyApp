package com.zy.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.zy.myapp.entity.Video;
import com.zy.myapp.utils.MediaUtil;

import java.util.List;

public class MyActivity extends Activity implements SurfaceHolder.Callback {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
//            return;

        //获取默认的SP
//        PreferenceManager.getDefaultSharedPreferences(this);

        List<Video> videos = MediaUtil.searchVoid(getApplicationContext());
        System.out.println(videos);

    }

    private void init() {
        SurfaceView mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(this);

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
