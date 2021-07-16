package edu.rit.connors.brandon.swcompanion.network.source;

import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;

public class Wookieepedia implements IDataSource<ArchiveArticle> {


    public Wookieepedia(){ }

    @Override
    public String getUrl() {
        return "https://starwars.fandom.com/wiki/Main_Page";
    }

    @Override
    public int getLogoId() {
        return R.drawable.wookieepedia;
    }

    @Override
    public String getTitle() {
        return "Wookieepedia";
    }
    @Override
    public String[] getSectionTitles(){
        return new String[]{"Trending", "Popular"};
    }
    @Override
    public boolean hasSections(){
        return getSectionTitles().length != 0;
    }
    @Override
    public boolean mobileRequired(int sectionId){
        return sectionId == 0 || sectionId== 1;
    }

    @Override
    public List<ArchiveArticle> parseDocument(Document doc, int sectionId) {

        List<ArchiveArticle> results = new ArrayList<>();
        String cssQuery = getCSSQuery(sectionId);
        Log.d("Wookieepedia", "parseDocument: " + cssQuery);
        Elements elements = doc.select(cssQuery);

        ArchiveArticle curItem;
        Element curElement;
        boolean hasURL;
        for(int i = 0; i < elements.size(); i++){

            curElement = elements.get(i);
            curItem = parseElement(curElement, sectionId);
            hasURL = !curItem.url.equals("");

            if(hasURL) {
                results.add(curItem);
            }
        }

        return results;
    }

    @Override
    public ArchiveArticle parseElement(Element element,int sectionId) {
        ArchiveArticle article;

        if(sectionId == 0 || sectionId == 1){
            article = parseTrendingPopular(element);
        }else{
            article = parseSearch(element);
        }
        return article;
    }

    private ArchiveArticle parseSearch(Element element) {

        ArchiveArticle article = new ArchiveArticle();

        Element root1 = element.selectFirst("article > h1 > a");
        Element root2 = element.selectFirst("article > div > a[href]");

        article.url = root2.attr("href");
        article.title = root1.attr("data-title");
        article.image = root1.attr("data-thumbnail");

        return article;
    }

    private ArchiveArticle parseTrendingPopular(@NotNull Element element){

        ArchiveArticle article = new ArchiveArticle();

        Element root1 = element.selectFirst("a");
        Element root2 = element.selectFirst("img");
        Element root3 = element.selectFirst("figcaption.mobile-gallery__image-caption > " +
                "span.mobile-gallery__image-caption-content");

        article.url = getPageURL(root1.attr("href"));
        article.image = root2.attr("data-src");
        article.title = root3.text();

        return article;
    }
    private String getCSSQuery(int sectionId){
        String query;

        switch(sectionId){
            case 0:
                query = "div.mobile-main-page__trending-articles > " +
                        "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
                        "div.mobile-gallery__column > figure.mobile-gallery__image";
                break;
            case 1:
                query = "div.mobile-main-page__popular-categories > " +
                        "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
                        "div.mobile-gallery__column > figure.mobile-gallery__image";
                break;
            default:
                query = "li.unified-search__result";
                break;
        }

        return query;
    }
    public static String getQueryURL(String queryText) {
        return "https://starwars.fandom.com/wiki/Special:Search?query=" + queryText;
    }
    public static String getPageURL(String itemHref){
        return "https://starwars.fandom.com" + itemHref;
    }
}
