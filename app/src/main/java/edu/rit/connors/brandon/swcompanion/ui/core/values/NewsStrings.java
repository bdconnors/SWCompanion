package edu.rit.connors.brandon.swcompanion.ui.core.values;

public class NewsStrings {
    public static final String ROOT_URL = "https://www.starwars.com/news";
    public static final String ARTICLES = "article";
    public static final String CONTENT_SECTION = "section.cb-content";
    public static final String PHOTO_SECTION = "section.cb-photo";
    public static final String BYLINE_SECTION = "div.byline";
    public static final String AUTHOR_SECTION = "div.byline-author";
    public static final String DATE_SECTION = "div.byline-date";
    public static final String CATEGORY_SECTION = "span.editorial";
    public static final String IMAGE_LINK = "data-original";
    public static final String CONTENT_BODY = "div.content-body";
    public static final String CURATED_IMAGE = "tm-curated-product-infinite-image";
    public static final String CURATED_SECTION = "tm-curated-product-infinite-content";
    public static final String CURATED_CATEGORY = "tm-curated-category";
    public static final String CURATED_TITLE = "tm-curated-title";

    public static String makeFooter(String category, String date){
        return category + " // " + date;
    }
    public static String makeAuthor(String name){
        return "by: " + name;
    }
}
