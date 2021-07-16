package edu.rit.connors.brandon.swcompanion.ui.util.adapter;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.ui.util.IListAdapter;

public abstract class RecyclerListAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements IListAdapter<T>{

    protected final Activity activity;
    protected final int listItemResId;
    protected List<T> items;

    public RecyclerListAdapter(Activity activity, int listItemResId, List<T> items) {
        this.activity = activity;
        this.listItemResId = listItemResId;
        this.items = items;
    }

    public RecyclerListAdapter(Activity activity, int listItemResId) {
        this.activity = activity;
        this.listItemResId = listItemResId;
        this.items = new ArrayList<>();
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public List<T> getItems() {
        return items;
    }


    public T getItem(int position) {
        return items.get(position);
    }


    public void clearItems() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}