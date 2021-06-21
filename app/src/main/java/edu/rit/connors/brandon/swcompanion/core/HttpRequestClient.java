package edu.rit.connors.brandon.swcompanion.core;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.core.values.HttpStrings;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpRequestClient {

    private static volatile HttpRequestClient instance;
    private final OkHttpClient client;

    private HttpRequestClient() {
        this.client = new OkHttpClient();
    }

    public static HttpRequestClient getInstance() {

        if (instance == null) {
            synchronized (HttpRequestClient.class) {
                if (instance == null)
                    instance = new HttpRequestClient();
            }
        }

        return instance;
    }


    public void request(String url, Callback callback){

        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public void request(String url, Callback callback, boolean forceMobile){

        Request request;
        if(forceMobile){
            request = new Request.Builder().addHeader(HttpStrings.USER_AGENT, HttpStrings.MOBILE_USER_AGENT).url(url).build();
        }else{
            request = new Request.Builder().url(url).build();
        }

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void requestMobile(String url, Callback callback){


        Request request = new Request.Builder().addHeader(HttpStrings.USER_AGENT, HttpStrings.MOBILE_USER_AGENT).url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void loadImageView(String url, ImageView imageView){
        if(url.isEmpty()){
            imageView.setImageResource(R.drawable.baseline_broken_image_white_24dp);
        }else {
            Picasso.get().load(url).error(R.drawable.baseline_broken_image_white_24dp).into(imageView);
        }
    }

}
