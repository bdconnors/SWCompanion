package edu.rit.connors.brandon.swcompanion.constants;


public enum AppPage {

    HOLONET("HoloNet"),

    ARCHIVE("Archive");

    private final String text;

    AppPage(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}


