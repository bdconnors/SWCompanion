package edu.rit.connors.brandon.swcompanion.network.source;



import org.jsoup.nodes.Document;

import java.util.List;

public interface IDataSource {
    int getLogoId();
    String getTitle();
    List<SourcePage> getPages();
    SourcePage getPage(int id);
    String[] getPageNames();
}
