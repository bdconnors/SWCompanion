package edu.rit.connors.brandon.swcompanion.network.source;

import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.domain.model.HoloNetArticle;

public abstract class SourcePage implements ISourcePage {
    private final int id;
    private final String name;
    private final String url;
    private final boolean mobileRequired;


    public SourcePage(int id, String name, String url){
        this.id = id;
        this.name = name;
        this.url = url;
        this.mobileRequired = false;
    }
    public SourcePage(int id, String name, String url, boolean mobileRequired) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.mobileRequired = mobileRequired;
    }

    public abstract Article parseElement(Element element);

    public abstract List<Article> parse(Document document);

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public boolean isMobileRequired() {
        return mobileRequired;
    }

    public String getName() {
        return name;
    }

}
