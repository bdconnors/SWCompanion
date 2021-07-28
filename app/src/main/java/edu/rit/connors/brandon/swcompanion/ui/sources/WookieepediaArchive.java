package edu.rit.connors.brandon.swcompanion.ui.sources;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.network.source.wookieepedia.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.ui.archive.ArchiveGridFragment;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class WookieepediaArchive extends TabPagerFragment {

    private static final String[] tabTitles = {"Trending","Popular"};
    private static final Wookieepedia source = new Wookieepedia();
    private static final ArchiveService service = new ArchiveService(source);
    private static final Fragment[] tabViews = new Fragment[]{
            new ArchiveGridFragment(service, 0),
            new ArchiveGridFragment(service, 1)
    };


    public WookieepediaArchive() {
        super(tabTitles, tabViews);
    }
}
