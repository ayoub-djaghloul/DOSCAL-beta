package com.ayoub.dosecal;

import android.graphics.drawable.Drawable;

public class element {
    private String name;
    private int img;

    public element(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }



}
