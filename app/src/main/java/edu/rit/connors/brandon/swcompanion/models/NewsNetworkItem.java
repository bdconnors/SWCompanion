package edu.rit.connors.brandon.swcompanion.models;

public class NewsNetworkItem extends NetworkItem {
    public String secondaryTitle;
    public String contentBody;

    public NewsNetworkItem(String secondaryTitle, String contentBody) {
        this.secondaryTitle = secondaryTitle;
        this.contentBody = contentBody;
    }

    public NewsNetworkItem(String id, String secondaryTitle, String contentBody) {
        super(id);
        this.secondaryTitle = secondaryTitle;
        this.contentBody = contentBody;
    }

    public NewsNetworkItem(String title, String imgURL, String pageURL, String secondaryTitle, String contentBody) {
        super(title, imgURL, pageURL);
        this.secondaryTitle = secondaryTitle;
        this.contentBody = contentBody;
    }

    public NewsNetworkItem(String id, String title, String imgURL, String pageURL, String secondaryTitle, String contentBody) {
        super(id, title, imgURL, pageURL);
        this.secondaryTitle = secondaryTitle;
        this.contentBody = contentBody;
    }

    public String getSecondaryTitle() {
        return secondaryTitle;
    }

    public void setSecondaryTitle(String secondaryTitle) {
        this.secondaryTitle = secondaryTitle;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }
}
