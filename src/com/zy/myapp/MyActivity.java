package com.zy.myapp;

import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //获取默认的SP
//        PreferenceManager.getDefaultSharedPreferences(this);

    }
}
