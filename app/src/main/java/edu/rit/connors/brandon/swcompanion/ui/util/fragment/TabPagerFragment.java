package edu.rit.connors.brandon.swcompanion.ui.util.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.constants.WebSource;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.TabPagerAdapter;

public abstract class TabPagerFragment extends Fragment {


    public TabLayout tabLayout;
    public FragmentStateAdapter adapter;
    public ViewPager2 pager;
    public final WebSource[] pages;
    public final Fragment[] fragments;

    public TabPagerFragment(WebSource[] pages, Fragment[] fragments){
        this.pages = pages;
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
                (tab, i) -> tab.setText(pages[i].toString())
        ).attach();
        return view;
    }


}
