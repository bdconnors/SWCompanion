package edu.rit.connors.brandon.swcompanion.ui.wiki;

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

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;

import edu.rit.connors.brandon.swcompanion.ui.adapters.TabPagerAdapter;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants;

public class WikiHome extends Fragment {

    public TabLayout tabLayout;
    public TabPagerAdapter adapter;
    public ViewPager2 pager;
    public String[] tabTitles;
    public ArrayList<Fragment> tabFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wiki_fragment, container, false);
        tabLayout = view.findViewById(R.id.tab_layout);
        pager = view.findViewById(R.id.pager);
        tabTitles = getResources().getStringArray(R.array.wiki_tabs);
        tabFragments = new ArrayList<>();
        tabFragments.add(new WikiGrid(DataSourceConstants.DataPage.WIKI_TRENDING));
        tabFragments.add(new WikiGrid(DataSourceConstants.DataPage.WIKI_POPULAR));
        adapter = new TabPagerAdapter(this, tabFragments);
        pager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, pager,
                (tab, position) -> tab.setText(tabTitles[position])
        ).attach();
        return view;
    }

}
