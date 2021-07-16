package edu.rit.connors.brandon.swcompanion.network.util;

import org.jsoup.nodes.Document;

import java.util.List;

import edu.rit.connors.brandon.swcompanion.constants.WebSource;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkList;
import okhttp3.Callback;
import okhttp3.Request;

public interface INetworkService<T>{
    Request buildRequest(String url, boolean mobile);
    void executeRequest(Callback callback, Request request);
    void load(NetworkList<T> listView);
}
