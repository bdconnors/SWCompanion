package edu.rit.connors.brandon.swcompanion.domain.source;

import android.util.Log;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.InfoArticle;

import static edu.rit.connors.brandon.swcompanion.domain.source.Wookieepedia.Content.POPULAR;
import static edu.rit.connors.brandon.swcompanion.domain.source.Wookieepedia.Content.SEARCH;
import static edu.rit.connors.brandon.swcompanion.domain.source.Wookieepedia.Content.TRENDING;

public class Wookieepedia implements IDataSource<InfoArticle> {

    public enum Content {
        TRENDING,POPULAR,SEARCH
    }

    public Content content = SEARCH;


    public Wookieepedia(Content content){
        this.content  = content;
    }

    public Wookieepedia(){ }

    @Override
    public String getUrl() {

        return MAIN_URL;
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
    public boolean mobileRequired(){
        return this.content == TRENDING || this.content == POPULAR;
    }

    @Override
    public List<InfoArticle> parseDocument(Document doc) {

        List<InfoArticle> results = new ArrayList<>();
        String cssQuery = getCSSQuery();
        Log.d("Wookieepedia", "parseDocument: " + cssQuery);
        Elements elements = doc.select(cssQuery);

        InfoArticle curItem;
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
    public InfoArticle parseElement(Element element) {
        InfoArticle article;

        if(this.content == TRENDING || this.content == POPULAR){
            article = parseTrendingPopular(element);
        }else{
            article = parseSearch(element);
        }
        return article;
    }

    private InfoArticle parseSearch(Element element) {

        InfoArticle article = new InfoArticle();

        Element root1 = element.selectFirst(SEARCH_TITLE);
        Element root2 = element.selectFirst(SEARCH_LINK);

        article.url = root2.attr("href");
        article.title = root1.attr(DATA_TITLE);
        article.image = root1.attr(DATA_THUMBNAIL);

        return article;
    }

    private InfoArticle parseTrendingPopular(@NotNull Element element){

        InfoArticle article = new InfoArticle();

        Element root1 = element.selectFirst("a");
        Element root2 = element.selectFirst("img");
        Element root3 = element.selectFirst(FIG_CAPTION);

        article.url = getPageURL(root1.attr("href"));
        article.image = root2.attr(DATA_SRC);
        article.title = root3.text();

        return article;
    }
    private String getCSSQuery(){
        String query;

        switch(this.content){
            case TRENDING:
                query = "div.mobile-main-page__trending-articles > " +
                        "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
                        "div.mobile-gallery__column > figure.mobile-gallery__image";
                break;
            case POPULAR:
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
        return QUERY_URL + queryText;
    }
    public static String getPageURL(String itemHref){
        return ROOT_URL + itemHref;
    }


    public static final String ROOT_URL = "https://starwars.fandom.com";
    public static final String MAIN_URL = "https://starwars.fandom.com/wiki/Main_Page";
    public static final String QUERY_URL = "https://starwars.fandom.com/wiki/Special:Search?query=";
    public static final String DATA_ID = "data-page-id";
    public static final String DATA_THUMBNAIL = "data-thumbnail";
    public static final String DATA_TITLE = "data-title";
    public static final String DATA_SRC = "data-src";

    public static final String SEARCH_TITLE = "article > h1 > a";
    public static final String SEARCH_CONTENT = "article > div.unified-search__result__content";
    public static final String SEARCH_LINK = "article > div > a[href]";
    public static final String FIG_CAPTION = "figcaption.mobile-gallery__image-caption > " +
            "span.mobile-gallery__image-caption-content";
}
