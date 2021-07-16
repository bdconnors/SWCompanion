package edu.rit.connors.brandon.swcompanion.domain.source;



import android.graphics.drawable.Drawable;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

public interface IDataSource<T> {
    List<T> parseDocument(Document doc);
    T parseElement(Element element);
    String getUrl();
    boolean mobileRequired();
    int getLogoId();
    String getTitle();
}
