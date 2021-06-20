package edu.rit.connors.brandon.swcompanion.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.adapters.GridListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.wiki.adapters.WikiGridListAdapter;
import edu.rit.connors.brandon.swcompanion.parsers.IDataSourceParser;

public abstract class GridListFragment extends NetworkListFragment {
    public GridView gridView;
    public GridListAdapter adapter;

    public GridListFragment(IDataSourceParser parser) {
        super(parser);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        gridView = view.findViewById(R.id.grid_view);
        adapter = new WikiGridListAdapter(getContext(), new ArrayList<>());
        gridView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadGrid();
    }

    public void loadGrid(){
        showSpinner();
    }
}
