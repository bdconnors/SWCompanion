package edu.rit.connors.brandon.swcompanion.ui.util.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.ui.util.IListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.RecyclerListAdapter;

public abstract class NetworkRecyclerFragment<T> extends NetworkList<T>{

    protected RecyclerView recyclerView;
    protected RecyclerView.LayoutManager layoutManager;

    public NetworkRecyclerFragment(INetworkService<T> service) {
        super(service);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_list_fragment, container, false);
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(this);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setAdapter(IListAdapter<T> adapter) {
        super.setAdapter(adapter);
        recyclerView.setAdapter((RecyclerListAdapter<T>)adapter);
    }
}
