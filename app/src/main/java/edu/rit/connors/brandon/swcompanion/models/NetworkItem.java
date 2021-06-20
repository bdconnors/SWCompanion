package edu.rit.connors.brandon.swcompanion.models;

import java.io.Serializable;

public class NetworkItem implements Serializable {
    public String id;
    public String title;
    public String imgURL;
    public String pageURL;

    public NetworkItem() { }

    public NetworkItem(String id) {
        this.id = id;
    }

    public NetworkItem(String title, String imgURL, String pageURL) {
        this.title = title;
        this.imgURL = imgURL;
        this.pageURL = pageURL;
    }

    public NetworkItem(String id, String title, String imgURL, String pageURL) {
        this.id = id;
        this.title = title;
        this.imgURL = imgURL;
        this.pageURL = pageURL;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }
}
