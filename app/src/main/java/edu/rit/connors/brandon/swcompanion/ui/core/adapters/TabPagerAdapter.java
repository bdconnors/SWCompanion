package edu.rit.connors.brandon.swcompanion.ui.core.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabPagerAdapter extends FragmentStateAdapter {

    public Fragment[] fragments;

    public TabPagerAdapter(FragmentActivity fragmentActivity, Fragment[] fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

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