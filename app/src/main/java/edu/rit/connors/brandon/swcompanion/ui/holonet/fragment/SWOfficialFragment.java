package edu.rit.connors.brandon.swcompanion.ui.holonet.fragment;

import edu.rit.connors.brandon.swcompanion.network.source.StarWarsNews;
import edu.rit.connors.brandon.swcompanion.network.service.HoloNetService;
import edu.rit.connors.brandon.swcompanion.ui.holonet.HoloNetListFragment;

public class SWOfficialFragment extends HoloNetListFragment {
    private static final StarWarsNews source = new StarWarsNews();
    private static final HoloNetService service = new HoloNetService(source);
    public SWOfficialFragment() {
        super(service, 0);
    }
}
