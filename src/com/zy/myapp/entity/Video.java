package com.zy.myapp.entity;

/**
 * Created by Administrator on 2015/3/3.
 */
public class Video {
    public String path;
    public String _id;
    public String duration;
    public String description;

    public Video(String path, String _id, String duration, String description) {
        this.path = path;
        this._id = _id;
        this.duration = duration;
        this.description = description;
    }
}
