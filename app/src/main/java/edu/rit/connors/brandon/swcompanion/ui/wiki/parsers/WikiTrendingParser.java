package edu.rit.connors.brandon.swcompanion.ui.wiki.parsers;

import org.jsoup.nodes.Element;

import edu.rit.connors.brandon.swcompanion.core.values.HtmlStrings;
import edu.rit.connors.brandon.swcompanion.core.values.WikiStrings;
import edu.rit.connors.brandon.swcompanion.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.core.DataSourceParser;

public class WikiTrendingParser extends DataSourceParser {

    public WikiTrendingParser() {
        super(WikiStrings.TRENDING, WikiStrings.MAIN_PAGE_URL);
    }

    @Override
    public ListItem parse(Element element) {
        Element root = element.selectFirst(HtmlStrings.A);
        Element img = element.selectFirst(HtmlStrings.IMG);
        Element caption = element.selectFirst(WikiStrings.FIG_CAPTION);


        String pageURL = WikiStrings.makePageURL(root.attr(HtmlStrings.HREF));
        String imgURL = img.attr(WikiStrings.DATA_SRC);
        String title = caption.text();

        return new ListItem(title, imgURL, pageURL);
    }
}
