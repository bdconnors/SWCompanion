package edu.rit.connors.brandon.swcompanion.core;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.core.models.ListItem;

public abstract class DataSourceParser {

    protected final String rootSelector;
    public final String sourceUrl;

    public DataSourceParser(String rootSelector, String sourceUrl){
        this.rootSelector = rootSelector;
        this.sourceUrl = sourceUrl;
    }

    public ArrayList<ListItem> parse(Document doc) {
        ArrayList<ListItem> items = new ArrayList<>();
        Elements elements = doc.select(rootSelector);

        ListItem item;
        for(int i = 0; i < elements.size(); i++){
            item = parse(elements.get(i));
            if(item != null) {
                item.setId(String.valueOf(i));
                items.add(item);
            }
        }

        return items;
    }

    public abstract ListItem parse(Element element);

    public String getRootSelector() {
        return rootSelector;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }
}
