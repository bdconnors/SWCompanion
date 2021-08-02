package edu.rit.connors.brandon.swcompanion.network.source;

import android.util.Log;

import java.util.List;
import java.util.Map;

public abstract class DataSource implements IDataSource {


    private final String title;
    private final int logoId;
    private final Map<DataPageType,DataPage> pages;


    public DataSource(String title, int logoId, Map<DataPageType,DataPage> pages){
        this.title = title;
        this.logoId = logoId;
        this.pages = pages;
        Log.d("DataSource", "Pages: "+pages.size());
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getLogoId() {
        return logoId;
    }

    @Override
    public Map<DataPageType,DataPage> getPages() {
        return pages;
    }
    @Override
    public DataPage getPage(DataPageType type){
        return pages.get(type);
    }

    /**@Override
    public List<SourcePage<T>> getPages(){
        return pages;
    }

    @Override
    public SourcePage<T> getPage(int id){
        return pages.get(id);
    }

    @Override
    public List<T> parse(Document document, int pageId) {
        SourcePage<T> page = getPage(pageId);
        Elements elements = page.getElements(document);
        return page.parse(elements);
    }
    public String[] getPageNames(){
        List<SourcePage<T>> pages = getPages();
        String[] names = new String[pages.size()];
        Log.d("DataSource", "pages.size(): "+pages.size());
        for(int i = 0; i < pages.size(); i++){
            names[i] = pages.get(i).getName();
        }
        Log.d("DataSource", "getPageNames: "+ Arrays.toString(names));
        return names;
    }**/

}
