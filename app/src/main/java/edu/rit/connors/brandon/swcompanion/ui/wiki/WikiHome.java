package edu.rit.connors.brandon.swcompanion.ui.wiki;
import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.core.fragments.GridListFragment;
import edu.rit.connors.brandon.swcompanion.core.fragments.TabPagerFragment;
import edu.rit.connors.brandon.swcompanion.core.values.WikiStrings;
import edu.rit.connors.brandon.swcompanion.ui.wiki.parsers.WikiPopularParser;
import edu.rit.connors.brandon.swcompanion.ui.wiki.parsers.WikiTrendingParser;

public class WikiHome extends TabPagerFragment {

    public WikiHome() {
        super(
                WikiStrings.TAB_TITLES,
                new Fragment[] {
                    new GridListFragment(new WikiTrendingParser()),
                    new GridListFragment(new WikiPopularParser())
                }
        );
    }
}
