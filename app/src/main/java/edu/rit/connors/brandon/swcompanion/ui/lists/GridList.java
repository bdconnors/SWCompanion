package edu.rit.connors.brandon.swcompanion.ui.lists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.ui.adapters.GridViewAdapter;

public abstract class GridList extends Fragment implements SwipeRefreshLayout.OnRefreshListener  {
    public GridView gridView;
    public GridViewAdapter adapter;
    protected SwipeRefreshLayout refreshLayout;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        gridView = view.findViewById(R.id.grid_view);
        adapter = new GridViewAdapter(getContext(), new ArrayList<>());
        gridView.setAdapter(adapter);
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        return view;
    }

    public abstract void loadGrid();
}
