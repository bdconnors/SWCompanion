package edu.rit.connors.brandon.swcompanion.network.source.wookieepedia;

import java.util.Arrays;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.SourcePage;

public class Wookieepedia extends DataSource {

    private static final String title = "Wookieepedia";
    private static final int logoId = R.drawable.wookieepedia;
    private static final List<SourcePage> pages = Arrays.asList(new TrendingPage(),new ArchivePopularPage());

    public Wookieepedia(){
        super(title, logoId, pages);
    }

    @Override
    public String[] getPageNames() {
        return new String[]{"Trending","Popular"};
    }

}
