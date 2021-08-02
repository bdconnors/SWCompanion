package edu.rit.connors.brandon.swcompanion.ui.holonet;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.network.service.HoloNetService;
import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class HoloNetHomeFragment extends TabPagerFragment {

    private static final StarWars swSource = new StarWars();


    protected static final String[] pageTitles = new String[]{"SW Official"};
    protected static final Fragment[] pageFragments = new Fragment[]{
            new HoloNetListFragment(swSource)
    };

    public HoloNetHomeFragment() {
        super(pageTitles, pageFragments);
    }

}
