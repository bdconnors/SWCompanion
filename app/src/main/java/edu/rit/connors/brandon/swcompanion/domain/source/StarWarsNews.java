package edu.rit.connors.brandon.swcompanion.domain.source;

import android.graphics.drawable.Drawable;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.NewsArticle;

public class StarWarsNews implements IDataSource<NewsArticle>{

    private static final String ROOT_URL = "https://www.starwars.com/news";
    private static final String ARTICLES = "article";
    private static final String CONTENT_SECTION = "section.cb-content";
    private static final String PHOTO_SECTION = "section.cb-photo";
    private static final String BYLINE_SECTION = "div.byline";
    private static final String AUTHOR_SECTION = "div.byline-author";
    private static final String DATE_SECTION = "div.byline-date";
    private static final String CATEGORY_SECTION = "span.editorial";
    private static final String IMAGE_LINK = "data-original";
    private static final String CONTENT_BODY = "div.content-body";

    @Override
    public String getUrl() {

        return ROOT_URL;
    }
    @Override
    public int getLogoId(){
        return R.drawable.sw_official;
    }

    @Override
    public String getTitle() {
        return "SW Official";
    }

    @Override
    public boolean mobileRequired(){
        return false;
    }

    @Override
    public List<NewsArticle> parseDocument(Document doc) {

        List<NewsArticle> results = new ArrayList<>();
        Elements elements = doc.select(ARTICLES);

        NewsArticle curItem;
        Element curElement;
        boolean hasURL;
        for(int i = 0; i < elements.size(); i++){

            curElement = elements.get(i);

            curItem = parseElement(curElement);

            hasURL = !curItem.url.equals("");

            if(hasURL) {
                results.add(curItem);
            }
        }

        return results;
    }

    @Override
    public NewsArticle parseElement(Element element){
        NewsArticle item = new NewsArticle();

        Element photoSection = element.selectFirst(PHOTO_SECTION);
        Element contentSection = element.selectFirst(CONTENT_SECTION);

        String title;
        String body;
        String imgURL;
        String pageURL;
        String author;
        String footer;

        if(photoSection != null && contentSection != null){

            Element contentBody = contentSection.selectFirst(CONTENT_BODY);

            if(contentBody != null) {

                Element bylineSection = contentSection.select(BYLINE_SECTION).get(0);
                Element authorSection = bylineSection.select(AUTHOR_SECTION).get(0);
                Element dateSection = bylineSection.select(DATE_SECTION).get(0);
                Element categorySection = dateSection.select(CATEGORY_SECTION).get(0);
                Element titleElement = contentSection.select("h2").get(0);
                Element imgLinkElement = photoSection.selectFirst("a");
                Element imgElement = imgLinkElement.selectFirst("img");


                String date = dateSection.ownText();
                String category = categorySection.text();
                footer = makeFooter(category, date);

                title = titleElement.text();
                imgURL = imgElement.attr(IMAGE_LINK);
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