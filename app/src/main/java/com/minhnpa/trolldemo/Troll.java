package com.minhnpa.trolldemo;

public class Troll {
    private String name;
    private String desc;
    private int image;
    private String url;

    public Troll(String name, String desc, int image, String url) {
        this.setName(name);
        this.setDesc(desc);
        this.setImage(image);
        this.setUrl(url);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
