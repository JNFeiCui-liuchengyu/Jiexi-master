package com.feicui.jiexi.bean;

/**
 * Created by ｌ on 2016/6/6.
 */
public class Bean {
    String title;
    String desc;
    String iconUrl;

    public Bean(){

    }
    public Bean(String title, String desc, String iconUrl) {
        this.title = title;
        this.desc = desc;
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
