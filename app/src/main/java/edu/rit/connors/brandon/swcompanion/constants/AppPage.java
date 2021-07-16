package edu.rit.connors.brandon.swcompanion.constants;


public enum AppPage {

    NEWS("News"),

    INFO("Info");

    private final String text;

    AppPage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}


