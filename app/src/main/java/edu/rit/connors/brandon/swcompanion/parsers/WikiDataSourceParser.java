package edu.rit.connors.brandon.swcompanion.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.NetworkItem;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants.*;


public class WikiDataSourceParser implements IDataSourceParser {

    public WikiDataSourceParser() { }

    @Override
    public NetworkItem parse(Element element, DataPage dataPage) {
        NetworkItem item = new NetworkItem();

        switch (dataPage){
            case WIKI_SEARCH:
                item = parseSearch(element);
                break;
            case WIKI_TRENDING:
            case WIKI_POPULAR:
                item = parseTrendingPopular(element);
                break;
        }

        return item;
    }

    @Override
    public ArrayList<NetworkItem> parse(Document doc, DataPage dataPage) {
        ArrayList<NetworkItem> items = new ArrayList<>();
        String selector = null;

        switch(dataPage){
            case WIKI_SEARCH:
                selector = CssQuery.Wiki.SEARCH_RESULT;
                break;
            case WIKI_TRENDING:
                selector = CssQuery.Wiki.TRENDING;
                break;
            case WIKI_POPULAR:
                selector = CssQuery.Wiki.POPULAR;
                break;
        }

        Elements elements = doc.select(selector);

        NetworkItem item;
        for(int i = 0; i < elements.size(); i++){
            item = parse(elements.get(i), dataPage);
            item.setId(String.valueOf(i));
            items.add(item);
        }

        return items;
    }

    private NetworkItem parseTrendingPopular(Element element){

        Element root = element.selectFirst(Html.Element.A);
        Element img = element.selectFirst(Html.Element.IMG);
        Element caption = element.selectFirst(CssQuery.Wiki.FIG_CAPTION);


        String pageURL = Url.Wiki.getPageItemURL(root.attr(Html.Attr.HREF));
        String imgURL = img.attr(Html.Attr.Wiki.DATA_SRC);
        String title = caption.text();

        return new NetworkItem(title, imgURL, pageURL);
    }

    private NetworkItem parseSearch(Element element){

        Element titleElement = element.selectFirst(CssQuery.Wiki.SearchResult.TITLE);

        String imgURL = titleElement.attr(Html.Attr.Wiki.DATA_THUMBNAIL);
        String titleText = titleElement.attr(Html.Attr.Wiki.DATA_TITLE);
        String pageURL = element.selectFirst(CssQuery.Wiki.SearchResult.LINK).attr(Html.Attr.HREF);

        return new NetworkItem(titleText, imgURL, pageURL);
    }
}
