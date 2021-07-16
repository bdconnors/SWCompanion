package edu.rit.connors.brandon.swcompanion.network.service;

import android.app.Activity;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class NetworkService<T> implements INetworkService<T> {

    private final OkHttpClient client = new OkHttpClient();
    private final IDataSource<T> dataSource;

    public NetworkService(IDataSource<T> dataSource){
        this.dataSource = dataSource;
    }

    public void load(NetworkList<T> listView, int sectionId){
        listView.setLoading(true);
        Activity activity = listView.getActivity();
        Log.d("NetworkService", "load: " + dataSource.getUrl());
        Request request = buildRequest(dataSource.getUrl(), dataSource.mobileRequired(sectionId));
        executeRequest(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                listView.setLoading(false);
                call.cancel();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String html = response.body().string();
                Document doc = Jsoup.parse(html);
                List<T> results = getDataSource().parseDocument(doc, sectionId);
                Log.d("NetworkService", "onResponse: " + results.size());
                activity.runOnUiThread(()->{
                    listView.getAdapter().setItems(results);
                    listView.setLoading(false);

                });
            }
        },request);
    }
    public void executeRequest(Callback callback, Request request){
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public Request buildRequest(String url, boolean mobile){

        Request.Builder builder = new Request.Builder().url(url);

        if(mobile){
            builder.addHeader("User-Agent", "Mozilla/5.0 (Android 4.4; Mobile; rv:41.0) " +
                    "Gecko/41.0 Firefox/41.0");
        }

        return builder.build();
    }

    public OkHttpClient getClient() {
        return client;
    }

    public IDataSource<T> getDataSource() {
        return dataSource;
    }
}
