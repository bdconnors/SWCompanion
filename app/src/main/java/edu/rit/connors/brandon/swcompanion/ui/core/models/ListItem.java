package edu.rit.connors.brandon.swcompanion.ui.core.models;

import java.io.Serializable;

public class ListItem implements Serializable {
    public String id;
    public String title;
    public String imgURL;
    public String pageURL;

    public ListItem() { }

    public ListItem(String id) {
        this.id = id;
    }

    public ListItem(String title, String imgURL, String pageURL) {
        this.title = title;
        this.imgURL = imgURL;
        this.pageURL = pageURL;
    }

    public ListItem(String id, String title, String imgURL, String pageURL) {
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
