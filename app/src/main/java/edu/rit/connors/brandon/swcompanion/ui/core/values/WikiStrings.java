package edu.rit.connors.brandon.swcompanion.ui.core.values;

public class WikiStrings {

    public static final String[] TAB_TITLES = {"Trending", "Popular"};
    public static final String ROOT_URL = "https://starwars.fandom.com";
    public static final String MAIN_PAGE_URL = "https://starwars.fandom.com/wiki/Main_Page";
    public static final String QUERY_URL = "https://starwars.fandom.com/wiki/Special:Search?query=";

    public static final String DATA_ID = "data-page-id";
    public static final String DATA_THUMBNAIL = "data-thumbnail";
    public static final String DATA_TITLE = "data-title";
    public static final String DATA_SRC = "data-src";

    public static final String SEARCH_RESULT = "li.unified-search__result";
    public static final String SEARCH_TITLE = "article > h1 > a";
    public static final String SEARCH_CONTENT = "article > div.unified-search__result__content";
    public static final String SEARCH_LINK = "article > div > a[href]";

    public static final String TRENDING = "div.mobile-main-page__trending-articles > " +
            "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
            "div.mobile-gallery__column > figure.mobile-gallery__image";
    public static final String POPULAR = "div.mobile-main-page__popular-categories > " +
            "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
            "div.mobile-gallery__column > figure.mobile-gallery__image";
    public static final String FIG_CAPTION = "figcaption.mobile-gallery__image-caption > " +
            "span.mobile-gallery__image-caption-content";

    public static String makeQueryURL(String queryText) {
        return QUERY_URL + queryText;
    }
    public static String makePageURL(String itemHref){
        return ROOT_URL + itemHref;
    }

}
