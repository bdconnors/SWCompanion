package edu.rit.connors.brandon.swcompanion.network.source;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.Article;

public abstract class DataPage implements IDataPage {
    private final String name;
    private final String url;
    private final boolean mobileRequired;


    public DataPage(String name, String url){
        this.name = name;
        this.url = url;
        this.mobileRequired = false;
    }
    public DataPage(String name, String url, boolean mobileRequired) {
        this.name = name;
        this.url = url;
        this.mobileRequired = mobileRequired;
    }

    public abstract Article parseElement(Element element);

    public abstract List<Article> parse(Document document);


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
