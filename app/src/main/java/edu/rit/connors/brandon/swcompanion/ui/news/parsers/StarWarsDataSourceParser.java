package edu.rit.connors.brandon.swcompanion.ui.news.parsers;

import org.jsoup.nodes.Element;

import edu.rit.connors.brandon.swcompanion.ui.core.models.NewsListItem;
import edu.rit.connors.brandon.swcompanion.ui.core.values.HtmlStrings;
import edu.rit.connors.brandon.swcompanion.ui.core.values.NewsStrings;
import edu.rit.connors.brandon.swcompanion.ui.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.ui.core.DataSourceParser;

public class StarWarsDataSourceParser extends DataSourceParser {

    public StarWarsDataSourceParser() {
        super(NewsStrings.ARTICLES, NewsStrings.ROOT_URL);
    }

    @Override
    public ListItem parse(Element element) {

        NewsListItem item = new NewsListItem();

        Element photoSection = element.selectFirst(NewsStrings.PHOTO_SECTION);
        Element contentSection = element.selectFirst(NewsStrings.CONTENT_SECTION);

        String title;
        String body;
        String imgURL;
        String pageURL;
        String author;
        String footer;

        if(photoSection != null && contentSection != null){

            Element contentBody = contentSection.selectFirst(NewsStrings.CONTENT_BODY);

             if(contentBody == null){
                 return null;
             }else {

                 Element bylineSection = contentSection.select(NewsStrings.BYLINE_SECTION).get(0);
                 Element authorSection = bylineSection.select(NewsStrings.AUTHOR_SECTION).get(0);
                 Element dateSection = bylineSection.select(NewsStrings.DATE_SECTION).get(0);
                 Element categorySection = dateSection.select(NewsStrings.CATEGORY_SECTION).get(0);
                 Element titleElement = contentSection.select(HtmlStrings.H2).get(0);
                 Element imgLinkElement = photoSection.selectFirst(HtmlStrings.A);
                 Element imgElement = imgLinkElement.selectFirst(HtmlStrings.IMG);


                 String date = dateSection.ownText();
                 String category = categorySection.text();
                 footer = NewsStrings.makeFooter(category, date);

                 title = titleElement.text();
                 imgURL = imgElement.attr(NewsStrings.IMAGE_LINK);
                 pageURL = imgLinkElement.attr(HtmlStrings.HREF);

                 author = NewsStrings.makeAuthor(authorSection.selectFirst(HtmlStrings.A).ownText());
                 body = contentBody.text();



                 item.setTitle(title);
                 item.setBodyText(body);
                 item.setImgURL(imgURL);
                 item.setPageURL(pageURL);
                 item.setAuthor(author);
                 item.setFooterText(footer);

                 return item;

             }


        }else{
            return null;
        }

    }
}
