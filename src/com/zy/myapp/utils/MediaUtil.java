package com.zy.myapp.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.zy.myapp.entity.Image;
import com.zy.myapp.entity.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/3/3.
 */
public class MediaUtil {

    private static MediaUtil mediaUtil;
    private static byte[] obj = new byte[0];//最节省内存

    private MediaUtil() {
    }

    public static MediaUtil newInstance() {
        if (mediaUtil == null) {
            synchronized (obj) {
                if (mediaUtil == null) {
                    mediaUtil = new MediaUtil();
                }
            }
        }
        return mediaUtil;
    }


    /**
     * 查询sd卡中的视频文件
     *
     * @param context
     * @return
     */
    public List<Video> searchVoid(Context context) {
        Cursor cursor = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        List<Video> videoList = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
                String _id = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media._ID));
                String description = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DESCRIPTION));
                String duration = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DURATION));
                if (Integer.valueOf(duration) > 2 * 1000) {
                    videoList.add(new Video(path, _id, duration, description));
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


    /**
     * 搜寻SD卡中的图片
     * @param context
     * @return
     */
    public List<Image> searchImages(Context context) {
        Cursor cursor = context.getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null,
                        MediaStore.Images.Media.MIME_TYPE + " = ? or " + MediaStore.Images.Media.MIME_TYPE + " = ?",
                        new String[]{"image/jpeg", "image/png"}, MediaStore.Images.Media.DATE_MODIFIED + " DESC");
        List<Image> imageList = new ArrayList<>();
        try {
            while (cursor.moveToNext()) {
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                String _id = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                String modifiedTime = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED));
                String size = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.SIZE));
                if (Double.valueOf(size) > 0) {
                    imageList.add(new Image(_id, path, modifiedTime));
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
                cursor = null;
            }

        }
        return imageList;
    }


}
