package edu.rit.connors.brandon.swcompanion.ui.util.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.IListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;


public abstract class NetworkGridFragment<T> extends NetworkList<T> {

    protected GridView gridView;
    protected GridListAdapter<T> adapter;

    public NetworkGridFragment(DataSource source) {
        super(source);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(this);
        gridView = view.findViewById(R.id.grid_view);
        return view;
    }

    @Override
    public void setAdapter(IListAdapter<T> adapter) {
        super.setAdapter(adapter);
        gridView.setAdapter((GridListAdapter<T>) adapter);
    }
}