package edu.rit.connors.brandon.swcompanion.ui.util.fragment;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.IListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.util.IRefreshable;

public abstract class NetworkList<T>extends Fragment implements IRefreshable {

    protected SwipeRefreshLayout refreshLayout;
    protected IListAdapter<T> adapter;
    protected final DataSource source;

    public NetworkList(DataSource source){
        this.source = source;
    }

    public SwipeRefreshLayout getRefreshLayout() {
        return refreshLayout;
    }

    public IListAdapter<T> getAdapter() {
        return adapter;
    }

    public void setAdapter(IListAdapter<T> adapter) {
        this.adapter = adapter;
    }

    public void setLoading(boolean isLoading){
        getRefreshLayout().setRefreshing(isLoading);
    }
}
