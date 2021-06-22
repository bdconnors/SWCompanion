package edu.rit.connors.brandon.swcompanion.api;

import com.google.gson.Gson;

import java.io.IOException;

import edu.rit.connors.brandon.swcompanion.api.models.Person;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SWApi {
    public OkHttpClient client = new OkHttpClient();
    public Person getPerson(int id){
        String url = ApiUrl.PEOPLE_URL + id;
        try(Response response = client.newCall(makeRequest(url)).execute()){
            String responseBody = response.body().toString();
            return new Gson().fromJson(responseBody, Person.class);
        } catch (IOException e) {
            return null;
        }
    }
    public Request makeRequest(String url){
        return new Request.Builder().url(url).build();
    }

}
