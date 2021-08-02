package edu.rit.connors.brandon.swcompanion.network.service;

import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkList;
import okhttp3.Callback;
import okhttp3.Request;

public interface INetworkService<T>{
    Request buildRequest(String url, boolean mobile);
    void executeRequest(Callback callback, Request request);
    void load(NetworkList<T> listView, DataSource dataSource);
}
