package edu.rit.connors.brandon.swcompanion.network.source.starwars;

import java.util.Arrays;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.SourcePage;

public class StarWars extends DataSource {

    private static final String title = "SW Official";
    private static final int logoId = R.drawable.sw_official;
    private static final List<SourcePage> pages = Arrays.asList(new NewsPage());

    public StarWars(){
        super(title, logoId, pages);
    }

    @Override
    public String[] getPageNames() {
        return new String[0];
    }


    /**@Override
    public String getUrl() {
        return "https://www.starwars.com/news";
    }
    @Override
    public int getLogoId(){
        return R.drawable.sw_official;
    }

    @Override
    public String getTitle() {
        return "SW Official";
    }

    @Override
    public boolean hasSections() {
        return false;
    }

    @Override
    public String[] getSectionTitles() {
        return null;
    }

    @Override
    public boolean mobileRequired(int sectionId){
        return false;
    }

    @Override
    public List<HoloNetArticle> parseDocument(Document doc, int sectionId) {

        /**List<HoloNetArticle> results = new ArrayList<>();
        Elements elements = doc.select("article");

        HoloNetArticle curItem;
        Element curElement;
        boolean hasURL;
        for(int i = 0; i < elements.size(); i++){

            curElement = elements.get(i);

            curItem = parseElement(curElement, sectionId);

            hasURL = !curItem.url.equals("");

            if(hasURL) {
                results.add(curItem);
            }
        }

        return results;
    }

    @Override
    public HoloNetArticle parseElement(Element element, int sectionId){
        HoloNetArticle item = new HoloNetArticle();

        Element photoSection = element.selectFirst("section.cb-photo");
        Element contentSection = element.selectFirst("section.cb-content");

        String title;
        String body;
        String imgURL;
        String pageURL;
        String author;
        String footer;

        if(photoSection != null && contentSection != null){

            Element contentBody = contentSection.selectFirst("div.content-body");

            if(contentBody != null) {

                Element bylineSection = contentSection.select("div.byline").get(0);
                Element authorSection = bylineSection.select("div.byline-author").get(0);
                Element dateSection = bylineSection.select("div.byline-date").get(0);
                Element categorySection = dateSection.select("span.editorial").get(0);
                Element titleElement = contentSection.select("h2").get(0);
                Element imgLinkElement = photoSection.selectFirst("a");
                Element imgElement = imgLinkElement.selectFirst("img");


                String date = dateSection.ownText();
                String category = categorySection.text();
                footer = makeFooter(category, date);

                title = titleElement.text();
                imgURL = imgElement.attr("data-original");
                pageURL = imgLinkElement.attr("href");

                author = makeAuthor(authorSection.selectFirst("a").ownText());
                body = contentBody.text();


                item.title = title;
                item.body = body;
                item.image = imgURL;
                item.url = pageURL;
                item.author = author;
                item.footer = footer;

            }
        }
        return item;
    }
    public static String makeFooter(String category, String date){
        return category + " // " + date;
    }
    public static String makeAuthor(String name){
        return "by: " + name;
    }**/

}