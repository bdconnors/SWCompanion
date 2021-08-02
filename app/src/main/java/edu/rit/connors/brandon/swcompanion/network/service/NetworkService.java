package edu.rit.connors.brandon.swcompanion.network.service;

import android.util.Log;

import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public abstract class NetworkService<T> implements INetworkService<T> {

    private final OkHttpClient client = new OkHttpClient();

    public NetworkService(){ }

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

}
