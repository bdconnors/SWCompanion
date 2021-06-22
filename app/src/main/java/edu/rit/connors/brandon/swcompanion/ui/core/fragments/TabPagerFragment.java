package edu.rit.connors.brandon.swcompanion.ui.core.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import edu.rit.connors.brandon.swcompanion.R;

import edu.rit.connors.brandon.swcompanion.ui.core.adapters.TabPagerAdapter;

public class TabPagerFragment extends Fragment {


    public TabLayout tabLayout;
    public TabPagerAdapter adapter;
    public ViewPager2 pager;
    public String[] titles;
    public Fragment[] fragments;

    public TabPagerFragment(String[] titles, Fragment[] fragments){
        this.titles = titles;
        this.fragments = fragments;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_pager_fragment, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        pager = view.findViewById(R.id.pager);
        adapter = new TabPagerAdapter(this, fragments);
        pager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, pager,
                (tab, position) -> tab.setText(titles[position])
        ).attach();
        return view;
    }

}
