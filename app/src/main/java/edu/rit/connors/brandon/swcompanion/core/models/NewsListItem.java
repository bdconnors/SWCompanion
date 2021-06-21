package edu.rit.connors.brandon.swcompanion.core.models;

public class NewsListItem extends ListItem {
    public String bodyText;
    public String author;
    public String footerText;

    public NewsListItem(){
        super();
        title = "";
        imgURL = "";
        bodyText = "";
        pageURL = "";
        author = "";
        footerText = "";
    }

    public NewsListItem(String id, String bodyText, String author, String footerText) {
        super(id);
        this.bodyText = bodyText;
        this.author = author;
        this.footerText = footerText;
    }

    public NewsListItem(String title, String imgURL, String pageURL, String bodyText, String author, String footerText) {
        super(title, imgURL, pageURL);
        this.bodyText = bodyText;
        this.author = author;
        this.footerText = footerText;
    }

    public NewsListItem(String id, String title, String imgURL, String pageURL, String bodyText, String author, String footerText) {
        super(id, title, imgURL, pageURL);
        this.bodyText = bodyText;
        this.author = author;
        this.footerText = footerText;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFooterText() {
        return footerText;
    }

    public void setFooterText(String footerText) {
        this.footerText = footerText;
    }
}
