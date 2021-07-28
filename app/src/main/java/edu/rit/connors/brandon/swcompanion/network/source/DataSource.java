package edu.rit.connors.brandon.swcompanion.network.source;

import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.List;

public abstract class DataSource implements IDataSource {
    private final String title;
    private final int logoId;
    private final List<SourcePage> pages;


    public DataSource(String title, int logoId, List<SourcePage> pages){
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
    public List<SourcePage> getPages() {
        return pages;
    }

    public SourcePage getPage(int id){
        return pages.get(id);
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
