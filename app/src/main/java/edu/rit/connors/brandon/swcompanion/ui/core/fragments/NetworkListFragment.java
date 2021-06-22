package edu.rit.connors.brandon.swcompanion.ui.core.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.ui.core.adapters.IListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.ui.core.DataSourceParser;
import edu.rit.connors.brandon.swcompanion.ui.core.HttpRequestClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public abstract class NetworkListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, Callback {

    protected SwipeRefreshLayout refreshLayout;
    protected DataSourceParser parser;
    protected IListAdapter adapter;
    protected boolean forceMobile = false;

    public NetworkListFragment(DataSourceParser parser){
        this.parser = parser;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        load();
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        getActivity().runOnUiThread(() -> {
            hideSpinner();
            Toast.makeText(getContext(),"Error Fetching Data",Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

        final String data = response.body().string();
        Document doc = Jsoup.parse(data);
        ArrayList<ListItem> items = parser.parse(doc);
        getActivity().runOnUiThread(() -> {
            hideSpinner();
            adapter.setItems(items);
        });
    }

    public void load() {
        showSpinner();
        HttpRequestClient.getInstance().request(parser.getSourceUrl(), this, forceMobile);

    }
    public void showSpinner(){
        refreshLayout.setRefreshing(true);
    }
    public void hideSpinner(){
        refreshLayout.setRefreshing(false);
    }

    public boolean isForceMobile() {
        return forceMobile;
    }

    public void setForceMobile(boolean forceMobile) {
        this.forceMobile = forceMobile;
    }
}
