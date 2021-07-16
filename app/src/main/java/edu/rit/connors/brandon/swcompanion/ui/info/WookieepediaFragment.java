package edu.rit.connors.brandon.swcompanion.ui.info;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.constants.WebSource;
import edu.rit.connors.brandon.swcompanion.domain.source.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.network.service.InfoService;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

import static edu.rit.connors.brandon.swcompanion.constants.WebSource.WIKI_POPULAR;
import static edu.rit.connors.brandon.swcompanion.constants.WebSource.WIKI_TRENDING;

public class WookieepediaFragment extends TabPagerFragment {
    private static final WebSource[] sources = new WebSource[]{
            WIKI_TRENDING,
            WIKI_POPULAR
    };
    public static final InfoService trendingService = new InfoService(new Wookieepedia(Wookieepedia.Content.TRENDING));
    public static final InfoService popularService = new InfoService(new Wookieepedia(Wookieepedia.Content.POPULAR));

    private static final Fragment[] fragments = new Fragment[]{
            new InfoNetworkGridFragment(trendingService),
            new InfoNetworkGridFragment(popularService)
    };

    public WookieepediaFragment() {
        super(sources,fragments);
    }
}
