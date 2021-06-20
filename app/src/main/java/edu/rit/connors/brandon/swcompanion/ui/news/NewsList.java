package edu.rit.connors.brandon.swcompanion.ui.news;

import edu.rit.connors.brandon.swcompanion.fragments.GridListFragment;
import edu.rit.connors.brandon.swcompanion.parsers.IDataSourceParser;

public class NewsList extends GridListFragment {

    public NewsList(IDataSourceParser parser) {
        super(parser);
    }

    @Override
    public void onRefresh() {

    }
}
