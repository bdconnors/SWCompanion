package edu.rit.connors.brandon.swcompanion.network.source;



import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public interface IDataSource<T> {
    List<T> parseDocument(Document doc, int sectionId);
    T parseElement(Element element, int sectionId);
    String getUrl();
    boolean mobileRequired(int sectionId);
    int getLogoId();
    String getTitle();
    boolean hasSections();
    String[] getSectionTitles();
}
