package edu.rit.connors.brandon.swcompanion.ui.wiki;

import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.core.DataSourceParser;
import edu.rit.connors.brandon.swcompanion.core.values.WikiStrings;
import edu.rit.connors.brandon.swcompanion.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.core.fragments.GridListFragment;
import edu.rit.connors.brandon.swcompanion.core.HttpRequestClient;
import okhttp3.Call;
import okhttp3.Response;

public class WikiGrid extends GridListFragment {

    public WikiGrid(DataSourceParser parser) {
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
        ArrayList<ListItem> items = parser.parse(doc);
        getActivity().runOnUiThread(() -> {
            hideSpinner();
            adapter.setItems(items);
        });
    }
    @Override
    public void load() {
        super.load();
        String url = WikiStrings.MAIN_PAGE_URL;
        HttpRequestClient.getInstance().requestMobile(url, this);
    }

}
