package edu.rit.connors.brandon.swcompanion.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public abstract class TabPagerAdapter extends FragmentStateAdapter {

    public ArrayList<Fragment> tabFragments;

    public TabPagerAdapter(FragmentActivity fragmentActivity, ArrayList<Fragment> tabFragments) {
        super(fragmentActivity);
        this.tabFragments = tabFragments;
    }

    public TabPagerAdapter(Fragment fragment, ArrayList<Fragment> tabFragments) {
        super(fragment);
        this.tabFragments = tabFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return tabFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return tabFragments.size();
    }
}