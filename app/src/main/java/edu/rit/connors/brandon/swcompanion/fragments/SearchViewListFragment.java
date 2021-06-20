package edu.rit.connors.brandon.swcompanion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.ui.wiki.adapters.WikiSearchListAdapter;
import edu.rit.connors.brandon.swcompanion.parsers.IDataSourceParser;

public abstract class SearchViewListFragment extends RecyclerListFragment {

    protected String queryText;

    public SearchViewListFragment(IDataSourceParser parser) {
        super(parser);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        adapter = new WikiSearchListAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public void submitSearch(){
        showSpinner();
    }
}
