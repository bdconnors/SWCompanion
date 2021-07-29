package edu.rit.connors.brandon.swcompanion.network.source.wookieepedia;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.source.SourcePage;

public class ArchivePopularPage extends SourcePage {

    public ArchivePopularPage(){
        super(1, "Popular", "https://starwars.fandom.com/wiki/Main_Page", true);
    }

    @Override
    public ArchiveArticle parseElement(Element element) {

        ArchiveArticle article = null;

        Element root1 = element.selectFirst("a");
        Element root2 = element.selectFirst("img");
        Element root3 = element.selectFirst("figcaption.mobile-gallery__image-caption > " +
                "span.mobile-gallery__image-caption-content");
        if(!(root1.attr("href").isEmpty())){
            article = new ArchiveArticle();
            article.url = "https://starwars.fandom.com" + root1.attr("href");
            article.image = root2.attr("data-src");
            article.title = root3.text();
        }
        return article;
    }
    public List<Article> parse(Document document) {
        List<Article> articles = new ArrayList<>();
        Elements elements = document.select("div.mobile-main-page__popular-categories > " +
                "div.mobile-gallery.mobile-gallery-navigational > div.mobile-gallery__columns > " +
                "div.mobile-gallery__column > figure.mobile-gallery__image");
        Article curArticle;
        for(Element element : elements){
            curArticle = parseElement(element);
            if(curArticle != null) {
                articles.add(curArticle);
            }
        }
        return articles;
    }

    public static String getPageURL(String itemHref){
        return "https://starwars.fandom.com" + itemHref;
    }
}
