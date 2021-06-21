package edu.rit.connors.brandon.swcompanion.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.core.adapters.ListAdapter;
import edu.rit.connors.brandon.swcompanion.core.fragments.RecyclerListFragment;
import edu.rit.connors.brandon.swcompanion.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.core.DataSourceParser;
import edu.rit.connors.brandon.swcompanion.core.HttpRequestClient;
import edu.rit.connors.brandon.swcompanion.ui.news.adapters.NewsListAdapter;
import okhttp3.Call;
import okhttp3.Response;

public class NewsList extends RecyclerListFragment {

    public NewsList(DataSourceParser parser) {
        super(parser);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        adapter = new NewsListAdapter(getContext(), new ArrayList<>());
        recyclerView.setAdapter((ListAdapter) adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

    @Override
    public void load() {
        super.load();
        HttpRequestClient.getInstance().request(parser.getSourceUrl(), this);
    }
}
