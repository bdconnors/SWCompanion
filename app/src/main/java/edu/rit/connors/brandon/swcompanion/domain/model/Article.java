package edu.rit.connors.brandon.swcompanion.domain.model;

public abstract class Article {
    public String url = "";
    public String title = "";
    public String image = "";

    public Article(String url, String title, String image){
        this.url = url;
        this.title = title;
        this.image = image;
    }
    public Article(){}
}
