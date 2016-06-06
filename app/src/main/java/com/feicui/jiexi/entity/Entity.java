package com.feicui.jiexi.entity;

import java.util.List;

/**
 * Created by ｌ on 2016/6/6.
 */
public class Entity {
    public String summary;
    public String icon;
    public String stamp;
    public String title;
    public int    nid;
    public String link;
    public int    type;

    public String getSummary() {
        return summary;
    }

    public String getIcon() {
        return icon;
    }

    public String getStamp() {
        return stamp;
    }

    public String getTitle() {
        return title;
    }

    public int getNid() {
        return nid;
    }

    public String getLink() {
        return link;
    }

    public int getType() {
        return type;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setType(int type) {
        this.type = type;
    }
    public String         message;
    public int            status;
    public List<DataBean> data;

    private static class DataBean {
        public String summary;
        public String icon;
        public String stamp;
        public String title;
        public int    nid;
        public String link;
        public int    type;
    }
}
