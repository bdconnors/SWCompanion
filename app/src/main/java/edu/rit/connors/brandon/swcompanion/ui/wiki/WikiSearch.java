package edu.rit.connors.brandon.swcompanion.ui.wiki;

import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.NetworkItem;
import edu.rit.connors.brandon.swcompanion.fragments.SearchViewListFragment;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants;
import edu.rit.connors.brandon.swcompanion.util.HttpRequestClient;
import edu.rit.connors.brandon.swcompanion.parsers.IDataSourceParser;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants.DataPage;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WikiSearch extends SearchViewListFragment implements Callback {


    public WikiSearch(IDataSourceParser parser) {
        super(parser);
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        getActivity().runOnUiThread(() -> {
            hideSpinner();
            Toast.makeText(getContext(),"Error Fetching Data",Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

        final String data = response.body().string();
        Document doc = Jsoup.parse(data);
        ArrayList<NetworkItem> items = parser.parse(doc, DataPage.WIKI_SEARCH);
        getActivity().runOnUiThread(() -> {
            hideSpinner();
            adapter.setItems(items);
        });
    }

    @Override
    public void submitSearch() {
        super.submitSearch();
        String url = DataSourceConstants.Url.Wiki.getQueryURL(getQueryText());
        HttpRequestClient.getInstance(getContext()).request(url, this);
    }

    @Override
    public void onRefresh() {
        submitSearch();
    }
}
