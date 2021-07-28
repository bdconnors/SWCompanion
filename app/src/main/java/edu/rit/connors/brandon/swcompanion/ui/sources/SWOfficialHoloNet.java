package edu.rit.connors.brandon.swcompanion.ui.sources;

import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.network.service.HoloNetService;
import edu.rit.connors.brandon.swcompanion.ui.holonet.HoloNetListFragment;

public class SWOfficialHoloNet extends HoloNetListFragment {

    private static final StarWars source = new StarWars();
    private static final HoloNetService service = new HoloNetService(source);

    public SWOfficialHoloNet() {
        super(service, 0);
    }
}
