package edu.rit.connors.brandon.swcompanion.ui.archive;


import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.network.source.wookieepedia.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class ArchiveHomeFragment extends TabPagerFragment {

    private static final Wookieepedia wkSource = new Wookieepedia();
    private static final StarWars swSource = new StarWars();

    protected static final Fragment[] pageFragments = new Fragment[]{
            new ArchiveGridFragment(wkSource),
            new ArchiveGridFragment(swSource)
    };
    protected static final String[] pageTitles = new String[]{"SW Official", "Wookieepedia"};


    public ArchiveHomeFragment() {
        super(pageTitles, pageFragments);
    }
}
