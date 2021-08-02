package edu.rit.connors.brandon.swcompanion.network.source.starwars;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.domain.model.HoloNetArticle;
import edu.rit.connors.brandon.swcompanion.network.source.DataPage;

public class HoloNetPage extends DataPage {

    public HoloNetPage(){
        super("SW Official","https://www.starwars.com/news");
    }


    @Override
    public List<Article> parse(Document document) {
        List<Article> articles = new ArrayList<>();
        Elements elements = document.select("article");
        Article curArticle;
        for(Element element : elements){
            curArticle = parseElement(element);
            if(curArticle != null) {
                articles.add(curArticle);
            }
        }
        return articles;
    }
    @Override
    public Article parseElement(Element element){
        HoloNetArticle item = null;

        Element photoSection = element.selectFirst("section.cb-photo");
        Element contentSection = element.selectFirst("section.cb-content");

        String title;
        String body;
        String imgURL;
        String pageURL;
        String author;
        String footer;

        if(photoSection != null && contentSection != null){

            Element contentBody = contentSection.selectFirst("div.content-body");

            if(contentBody != null) {
                item = new HoloNetArticle();

                Element bylineSection = contentSection.select("div.byline").get(0);
                Element authorSection = bylineSection.select("div.byline-author").get(0);
                Element dateSection = bylineSection.select("div.byline-date").get(0);
                Element categorySection = dateSection.select("span.editorial").get(0);
                Element titleElement = contentSection.select("h2").get(0);
                Element imgLinkElement = photoSection.selectFirst("a");
                Element imgElement = imgLinkElement.selectFirst("img");


                String date = dateSection.ownText();
                String category = categorySection.text();
                footer = makeFooter(category, date);

                title = titleElement.text();
                imgURL = imgElement.attr("data-original");
                pageURL = imgLinkElement.attr("href");

                author = makeAuthor(authorSection.selectFirst("a").ownText());
                body = contentBody.text();


                item.title = title;
                item.body = body;
                item.image = imgURL;
                item.url = pageURL;
                item.author = author;
                item.footer = footer;

            }
        }
        return item;
    }

    public static String makeFooter(String category, String date){
        return category + " // " + date;
    }
    public static String makeAuthor(String name){
        return "by: " + name;
    }

}
