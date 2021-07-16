package edu.rit.connors.brandon.swcompanion.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.rit.connors.brandon.swcompanion.constants.WebSource;

import edu.rit.connors.brandon.swcompanion.domain.model.NewsArticle;
import edu.rit.connors.brandon.swcompanion.network.util.INetworkService;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkRecyclerFragment;

public class NewsNetworkRecyclerFragment extends NetworkRecyclerFragment<NewsArticle> {

    public NewsNetworkRecyclerFragment(INetworkService<NewsArticle> service) {
        super(service);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.setAdapter(new NewsRecyclerListAdapter(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        load();
    }

    public void load() {
        getService().load(this);
    }

    @Override
    public void onRefresh() {
        load();
    }
}
