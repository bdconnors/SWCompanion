package edu.rit.connors.brandon.swcompanion.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import edu.rit.connors.brandon.swcompanion.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpRequestClient {

    private static volatile HttpRequestClient instance;
    private final OkHttpClient client;
    private final Context ctx;

    private HttpRequestClient(Context context) {
        this.ctx = context;
        this.client = new OkHttpClient();
    }

    public static HttpRequestClient getInstance(Context context) {

        if (instance == null) {
            synchronized (HttpRequestClient.class) {
                if (instance == null)
                    instance = new HttpRequestClient(context);
            }
        }

        return instance;
    }


    public void request(String url, Callback callback){
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void requestMobile(String url, Callback callback){
        String agentStr = ctx.getString(R.string.user_agent);
        String mobileStr = ctx.getString(R.string.mobile_user_agent);


        Request request = new Request.Builder().addHeader(agentStr, mobileStr).url(url).build();

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
