package com.zy.myapp.entity;

/**
 * Created by Administrator on 2015/3/3.
 */
public class Image {
    public String _id;
    public String path;
    public String modifiedTime;

    public Image(String _id, String path, String modifiedTime) {
        this._id = _id;
        this.path = path;
        this.modifiedTime = modifiedTime;
    }
}
