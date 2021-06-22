package edu.rit.connors.brandon.swcompanion.api.providers;

import android.app.Activity;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import edu.rit.connors.brandon.swcompanion.api.ApiUrl;
import edu.rit.connors.brandon.swcompanion.api.models.Person;
import edu.rit.connors.brandon.swcompanion.ui.core.HttpRequestClient;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class PersonProvider implements Callback {

    private Activity activity;
    protected String url;
    protected ObjectMapper mapper;
    public ArrayList<Person> people;


    public PersonProvider(Activity activity, String url) {
        this.activity = activity;
        this.url = url;
        this.mapper = new ObjectMapper();
    }

    public void load(){
        HttpRequestClient.getInstance().request(ApiUrl.PEOPLE_URL, this);
    }
    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {

    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        String body = response.body().string();
        JsonNode node = mapper.readTree(body);
        JsonNode results = node.get("results");
        Person[] arr = mapper.convertValue(results, Person[].class);
        this.people = new ArrayList<>(Arrays.asList(arr));
        activity.runOnUiThread(()->{
            Toast.makeText(activity, String.valueOf(this.people.size()), Toast.LENGTH_LONG).show();
        });
    }
}
