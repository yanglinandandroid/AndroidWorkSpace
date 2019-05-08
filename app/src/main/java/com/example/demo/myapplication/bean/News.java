package com.example.demo.myapplication.bean;

import java.io.Serializable;

public class News implements Serializable {
    private String title;
    private String path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
