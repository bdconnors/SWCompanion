package edu.rit.connors.brandon.swcompanion.core.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.WebViewActivity;
import edu.rit.connors.brandon.swcompanion.core.models.ListItem;

public abstract class ListAdapter extends Adapter<RecyclerView.ViewHolder> implements IListAdapter, OnClickListener {
    protected final Context context;
    protected ArrayList<ListItem> items;

    public ListAdapter(Context context, ArrayList<ListItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public void onClick(View view) {

        int position = (int) view.getTag();
        ListItem item = getItem(position);

        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebViewActivity.URL_EXTRA, item.getPageURL());

        context.startActivity(intent);
    }

    @Override
    public void setItems(ArrayList<ListItem> items){
        this.items = items;
        this.notifyDataSetChanged();
    }

    @Override
    public void clearItems(){
        items = new ArrayList<>();
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public ListItem getItem(int position){
        return items.get(position);
    }

}
