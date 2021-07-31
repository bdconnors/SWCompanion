package edu.rit.connors.brandon.swcompanion.ui.archive;


import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.network.source.wookieepedia.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class ArchiveHomeFragment extends TabPagerFragment {

    private static final Wookieepedia wookieepedia = new Wookieepedia();
    private static final StarWars starWars = new StarWars();

    private static final ArchiveService wookiepeediaService = new ArchiveService(wookieepedia);
    private static final ArchiveService starWarsService = new ArchiveService(starWars);

    protected static final Fragment[] pageFragments = new Fragment[]{
            new ArchiveGridFragment(wookiepeediaService, 0),
            new ArchiveGridFragment(starWarsService, 1)
    };
    protected static final String[] pageTitles = new String[]{"SW Official", "Wookieepedia"};


    public ArchiveHomeFragment() {
        super(pageTitles, pageFragments);
    }
}
