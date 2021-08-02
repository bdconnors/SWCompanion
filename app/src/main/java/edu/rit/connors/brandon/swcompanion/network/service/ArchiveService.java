package edu.rit.connors.brandon.swcompanion.network.service;

import android.app.Activity;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.DataPage;
import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class ArchiveService extends NetworkService<Article> {

    public void load(NetworkList<Article> listView, DataSource dataSource){
        listView.setLoading(true);
        Activity activity = listView.getActivity();
        DataPage page = dataSource.getPage(IDataSource.DataPageType.ARCHIVE);
        Request request = buildRequest(page.getUrl(), page.isMobileRequired());
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
                List<Article> results = page.parse(doc);
                Log.d("NetworkService", "onResponse: " + results.size());
                activity.runOnUiThread(()->{
                    listView.getAdapter().setItems(results);
                    listView.setLoading(false);

                });
            }
        },request);
    }

}
