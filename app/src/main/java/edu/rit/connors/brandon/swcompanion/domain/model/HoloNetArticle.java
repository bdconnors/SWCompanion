package edu.rit.connors.brandon.swcompanion.domain.model;

public class HoloNetArticle extends Article {

    public String author = "";
    public String body = "";
    public String footer = "";

    public HoloNetArticle(String url, String title, String image, String author, String body, String footer) {
        super(url, title, image);
        this.author = author;
        this.body = body;
        this.footer = footer;
    }
    public HoloNetArticle(){}
}
