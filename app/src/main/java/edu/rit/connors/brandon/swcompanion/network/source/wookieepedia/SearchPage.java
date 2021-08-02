package edu.rit.connors.brandon.swcompanion.network.source.wookieepedia;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.source.DataPage;

public class SearchPage extends DataPage {

    public SearchPage() {
        super("Search", "https://starwars.fandom.com/wiki/Special:Search?query=");
    }

    @Override
    public ArchiveArticle parseElement(Element element) {
        ArchiveArticle article = new ArchiveArticle();

        Element root1 = element.selectFirst("article > h1 > a");
        Element root2 = element.selectFirst("article > div > a[href]");

        article.url = root2.attr("href");
        article.title = root1.attr("data-title");
        article.image = root1.attr("data-thumbnail");

        return article;
    }
    public List<Article> parse(Document document) {
        List<Article> articles = new ArrayList<>();
        Elements elements = document.select("li.unified-search__result");
        Article curArticle;
        for(Element element : elements){
            curArticle = parseElement(element);
            if(curArticle != null) {
                articles.add(curArticle);
            }
        }
        return articles;
    }
}
