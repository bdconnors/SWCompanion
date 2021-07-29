package edu.rit.connors.brandon.swcompanion.ui.sources;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.network.source.wookieepedia.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.ui.archive.ArchiveGridFragment;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class SWOfficialArchive extends TabPagerFragment {

    private static final StarWars source = new StarWars();
    private static final String[] tabTitles = source.getPageNames();
    private static final ArchiveService service = new ArchiveService(source);
    private static final Fragment[] tabViews = new Fragment[]{
            new ArchiveGridFragment(service, 1)
    };

    public SWOfficialArchive() {
        super(tabTitles, tabViews);
    }

}
