package edu.rit.connors.brandon.swcompanion.ui.wiki.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.adapters.TabPagerAdapter;

public class WikiTabPagerAdapter extends TabPagerAdapter {
    public WikiTabPagerAdapter(FragmentActivity fragmentActivity, ArrayList<Fragment> tabFragments) {
        super(fragmentActivity, tabFragments);
    }

    public WikiTabPagerAdapter(Fragment fragment, ArrayList<Fragment> tabFragments) {
        super(fragment, tabFragments);
    }
}
