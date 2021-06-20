package edu.rit.connors.brandon.swcompanion.ui.wiki.adapters;

import android.content.Context;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.adapters.SearchListAdapter;
import edu.rit.connors.brandon.swcompanion.models.NetworkItem;

public class WikiSearchListAdapter extends SearchListAdapter {
    public WikiSearchListAdapter(Context context, ArrayList<NetworkItem> items) {
        super(context, items);
    }
}
