package edu.rit.connors.brandon.swcompanion.core.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.core.adapters.ListAdapter;
import edu.rit.connors.brandon.swcompanion.core.adapters.SearchListAdapter;
import edu.rit.connors.brandon.swcompanion.core.DataSourceParser;
import edu.rit.connors.brandon.swcompanion.core.HttpRequestClient;

public class SearchViewListFragment extends RecyclerListFragment {

    protected String queryText;

    public SearchViewListFragment(DataSourceParser parser) {
        super(parser);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        adapter = new SearchListAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter((ListAdapter)adapter);
        return view;
    }

    @Override
    public void load() {
        super.load();
        String url = getQueryURL();
        HttpRequestClient.getInstance().request(url,this);
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public String getQueryURL(){
        return parser.getSourceUrl() + getQueryText();
    }
}
