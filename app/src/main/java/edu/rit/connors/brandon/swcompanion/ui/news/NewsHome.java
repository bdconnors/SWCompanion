package edu.rit.connors.brandon.swcompanion.ui.news;

import androidx.fragment.app.Fragment;

import edu.rit.connors.brandon.swcompanion.ui.core.fragments.TabPagerFragment;
import edu.rit.connors.brandon.swcompanion.ui.news.parsers.StarWarsDataSourceParser;

public class NewsHome extends TabPagerFragment {
    public NewsHome() {
        super(new String[]{"StarWars.com"}, new Fragment[]{new NewsList(new StarWarsDataSourceParser())});
    }
}
