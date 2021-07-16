package edu.rit.connors.brandon.swcompanion.ui.archive.fragment;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.network.source.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.ui.archive.ArchiveGridFragment;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.TabPagerFragment;

public class WookieepediaFragment extends TabPagerFragment {

    private static final Wookieepedia source = new Wookieepedia();
    private static final ArchiveService service = new ArchiveService(source);
    private static final String[] tabs = source.getSectionTitles();

    private static final Fragment[] fragments = new Fragment[]{
            new ArchiveGridFragment(service,0),
            new ArchiveGridFragment(service, 1)
    };

    public WookieepediaFragment() {
        super(tabs,fragments);
    }
}
