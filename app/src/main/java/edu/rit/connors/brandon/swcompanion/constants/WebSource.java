package edu.rit.connors.brandon.swcompanion.constants;

public enum WebSource {
    WIKI_TRENDING("Trending"),

    WIKI_POPULAR("Popular"),

    WIKI_SEARCH("Search"),

    NEWS_STARWARS("SW Official"),

    WOOKIEEPEDIA("Wookieepedia");

    private final String text;

    WebSource(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
