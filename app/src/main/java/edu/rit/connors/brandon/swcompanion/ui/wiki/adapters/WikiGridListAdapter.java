package edu.rit.connors.brandon.swcompanion.ui.wiki.adapters;

import android.content.Context;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.NetworkItem;
import edu.rit.connors.brandon.swcompanion.adapters.GridListAdapter;

public class WikiGridListAdapter extends GridListAdapter {
    public WikiGridListAdapter(Context ctx, ArrayList<NetworkItem> items) {
        super(ctx, items);
    }
}
