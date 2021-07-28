package edu.rit.connors.brandon.swcompanion.network.service;

import android.app.Activity;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.network.source.SourcePage;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class NetworkService<T> implements INetworkService<T> {

    private final OkHttpClient client = new OkHttpClient();
    private final DataSource dataSource;

    public NetworkService(DataSource dataSource){
        this.dataSource = dataSource;
        Log.d("NetworkService", "DataSource: "+dataSource.getTitle());
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

    public DataSource getDataSource() {
        return dataSource;
    }
}
