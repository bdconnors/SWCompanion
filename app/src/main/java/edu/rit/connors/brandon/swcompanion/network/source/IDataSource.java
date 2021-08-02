package edu.rit.connors.brandon.swcompanion.network.source;



import java.util.List;
import java.util.Map;

public interface IDataSource {
    enum DataPageType {
        ARCHIVE,HOLO_NET
    }
    int getLogoId();
    String getTitle();
    Map<DataPageType,DataPage> getPages();
    DataPage getPage(DataPageType type);
}
