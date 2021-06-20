package edu.rit.connors.brandon.swcompanion.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.parsers.IDataSourceParser;

public abstract class NetworkListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    protected SwipeRefreshLayout refreshLayout;
    protected IDataSourceParser parser;

    public NetworkListFragment(IDataSourceParser parser){
        this.parser = parser;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(this);
    }

    public void showSpinner(){
        refreshLayout.setRefreshing(true);
    }
    public void hideSpinner(){
        refreshLayout.setRefreshing(false);
    }
}
