package com.example.healthcareproject.Model;

public class ArticleModel {
    int img;
    String title;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArticleModel(int img, String title) {
        this.img = img;
        this.title = title;
    }
}
