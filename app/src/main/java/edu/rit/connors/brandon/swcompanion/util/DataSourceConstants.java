package edu.rit.connors.brandon.swcompanion.util;


public class DataSourceConstants {

    public enum DataPage {
        WIKI_SEARCH, WIKI_TRENDING, WIKI_POPULAR
    }

    public static class Url {

        public static class Wiki {

            public static final String ROOT = "https://starwars.fandom.com";
            public static final String MAIN = "https://starwars.fandom.com/wiki/Main_Page";
            public static final String QUERY = "https://starwars.fandom.com/wiki/Special:Search?query=";

            public static String getQueryURL(String queryText) {
                return QUERY + queryText;
            }
            public static String getPageItemURL(String itemHref){
                return ROOT + itemHref;
            }
        }
    }

    public static class Html {

        public static class Element {

            public static final String A = "a";
            public static final String IMG = "img";
        }

        public static class Attr {

            public static final String HREF = "href";
            public static final String ALT = "alt";
            public static final String SRC = "src";

            public static class Wiki {
                public static final String DATA_ID = "data-page-id";
                public static final String DATA_THUMBNAIL = "data-thumbnail";
                public static final String DATA_TITLE = "data-title";
                public static final String DATA_SRC = "data-src";
            }
        }
    }

    public static class CssQuery {

        public static class Wiki {

            public static final String TRENDING = "div.mobile-main-page__trending-articles > " +
                    "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
                    "div.mobile-gallery__column > figure.mobile-gallery__image";
            public static final String POPULAR = "div.mobile-main-page__popular-categories > " +
                    "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
                    "div.mobile-gallery__column > figure.mobile-gallery__image";
            public static final String FIG_CAPTION = "figcaption.mobile-gallery__image-caption > " +
                    "span.mobile-gallery__image-caption-content";
            public static final String SEARCH_RESULT = "li.unified-search__result";

            public static class SearchResult {
                public static final String TITLE = "article > h1 > a";
                public static final String CONTENT = "article > div.unified-search__result__content";
                public static final String LINK = "article > div > a[href]";
            }
        }
    }
}
