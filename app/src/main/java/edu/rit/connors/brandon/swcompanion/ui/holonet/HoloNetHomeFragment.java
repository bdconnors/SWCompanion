package edu.rit.connors.brandon.swcompanion.ui.holonet;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class HoloNetHomeFragment extends TabPagerFragment {

    private static final StarWars starWars = new StarWars();
    private static final ArchiveService starWarsService = new ArchiveService(starWars);

    protected static final String[] pageTitles = new String[]{"SW Official"};
    protected static final Fragment[] pageFragments = new Fragment[]{
            new HoloNetListFragment(starWarsService,0)
    };

    public HoloNetHomeFragment() {
        super(pageTitles, pageFragments);
    }

}
