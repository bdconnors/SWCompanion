package edu.rit.connors.brandon.swcompanion.ui.wiki;

import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.PageItem;
import edu.rit.connors.brandon.swcompanion.ui.lists.RecyclerList;
import edu.rit.connors.brandon.swcompanion.ui.lists.SearchViewList;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants.DataPage;
import edu.rit.connors.brandon.swcompanion.util.HttpRequestClient;
import edu.rit.connors.brandon.swcompanion.util.parsers.WikiDataSourceParser;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WikiSearch extends SearchViewList implements Callback {


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
        ArrayList<PageItem> items = WikiDataSourceParser
                .getInstance().parse(doc, DataPage.WIKI_SEARCH);
        getActivity().runOnUiThread(() -> {
            refreshLayout.setRefreshing(false);
            adapter.setItems(items);
        });
    }

    @Override
    public void submitSearch() {
        refreshLayout.setRefreshing(true);
        String url = DataSourceConstants.Url.Wiki.getQueryURL(getQueryText());
        HttpRequestClient.getInstance(getContext()).request(url, this);
    }

    @Override
    public void onRefresh() {
        submitSearch();
    }
}
