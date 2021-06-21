package edu.rit.connors.brandon.swcompanion.ui.wiki.parsers;

import org.jsoup.nodes.Element;

import edu.rit.connors.brandon.swcompanion.core.values.HtmlStrings;
import edu.rit.connors.brandon.swcompanion.core.values.WikiStrings;
import edu.rit.connors.brandon.swcompanion.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.core.DataSourceParser;


public class WikiSearchParser extends DataSourceParser {

    public WikiSearchParser() {

        super(WikiStrings.SEARCH_RESULT, WikiStrings.QUERY_URL);
    }

    @Override
    public ListItem parse(Element element) {
        Element titleElement = element.selectFirst(WikiStrings.SEARCH_TITLE);

        String imgURL = titleElement.attr(WikiStrings.DATA_THUMBNAIL);
        String titleText = titleElement.attr(WikiStrings.DATA_TITLE);
        String pageURL = element.selectFirst(WikiStrings.SEARCH_LINK).attr(HtmlStrings.HREF);

        return new ListItem(titleText, imgURL, pageURL);
    }
}
