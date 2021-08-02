package edu.rit.connors.brandon.swcompanion.network.source.wookieepedia;

import java.util.HashMap;
import java.util.Map;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.DataPage;

public class Wookieepedia extends DataSource {

    private static final String title = "Wookieepedia";
    private static final int logoId = R.drawable.wookieepedia;
    private static final Map<DataPageType, DataPage> pages = new HashMap<DataPageType, DataPage>(){{
        put(DataPageType.ARCHIVE, new ArchivePage());
    }};

    public Wookieepedia(){
        super(title, logoId, pages);
    }


}
