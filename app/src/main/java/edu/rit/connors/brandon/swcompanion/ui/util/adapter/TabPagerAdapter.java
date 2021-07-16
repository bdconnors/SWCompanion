package edu.rit.connors.brandon.swcompanion.ui.util.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabPagerAdapter extends FragmentStateAdapter {


    private final Fragment[] fragments;
    public TabPagerAdapter(Fragment fragment, Fragment[] fragments) {
        super(fragment);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }

}