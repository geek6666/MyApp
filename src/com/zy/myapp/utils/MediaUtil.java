package com.zy.myapp.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.zy.myapp.entity.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/3.
 */
public class MediaUtil {


    /**
     * 查询sd卡中的视频文件
     *
     * @param context
     * @return
     */
    public static List<Video> searchVoid(Context context) {
        Cursor cursor = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        List<Video> videoList = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
                String _id = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media._ID));
                String description = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DESCRIPTION));
                String duration = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
                if (Integer.valueOf(duration) > 10 * 1000) {
                    videoList.add(new Video(path, _id, duration,description));
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }
        }
        return videoList;
    }

}
