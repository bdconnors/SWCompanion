package edu.rit.connors.brandon.swcompanion.network.source;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.Article;

public interface ISourcePage {
    Article parseElement(Element element);
    List<Article> parse(Document document);
    int getId();
    String getUrl();
    boolean isMobileRequired();
    String getName();
}
