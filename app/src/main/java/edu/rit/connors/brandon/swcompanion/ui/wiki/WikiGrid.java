package edu.rit.connors.brandon.swcompanion.ui.wiki;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.models.PageItem;
import edu.rit.connors.brandon.swcompanion.ui.lists.GridList;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants;
import edu.rit.connors.brandon.swcompanion.util.HttpRequestClient;
import edu.rit.connors.brandon.swcompanion.util.parsers.WikiDataSourceParser;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WikiGrid extends GridList implements Callback{

    private final DataSourceConstants.DataPage page;

    public WikiGrid(DataSourceConstants.DataPage page) {
        this.page = page;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(this);
        loadGrid();
    }


    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        getActivity().runOnUiThread(() -> {
            refreshLayout.setRefreshing(false);
            Toast.makeText(getContext(),"Error Fetching Data",Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        final String data = response.body().string();
        Document doc = Jsoup.parse(data);
        ArrayList<PageItem> items = WikiDataSourceParser.getInstance().parse(doc, page);
        getActivity().runOnUiThread(() -> {
            refreshLayout.setRefreshing(false);
            adapter.setItems(items);
        });
    }
    @Override
    public void loadGrid() {
        refreshLayout.setRefreshing(true);
        String url = DataSourceConstants.Url.Wiki.MAIN;
        HttpRequestClient.getInstance(getContext()).requestMobile(url, this);
    }

    @Override
    public void onRefresh() {
        loadGrid();
    }
}
