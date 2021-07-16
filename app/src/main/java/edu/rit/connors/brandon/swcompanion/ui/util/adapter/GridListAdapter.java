package edu.rit.connors.brandon.swcompanion.ui.util.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.ui.util.IListAdapter;

public abstract class GridListAdapter<T> extends BaseAdapter implements IListAdapter<T>{

    private final Context context;
    private final int itemResId;
    private List<T> items;

    public GridListAdapter(Context context, int listItemResId, List<T> items) {
        this.context = context;
        this.itemResId = listItemResId;
        this.items = items;
    }

    public GridListAdapter(Context context, int listItemResId) {
        this.context = context;
        this.itemResId = listItemResId;
        this.items = new ArrayList<>();
    }


    public ViewHolder makeViewHolder(View view, OnClickListener onClickListener){

        ViewHolder viewHolder;
        viewHolder = new ViewHolder();
        viewHolder.imageView = view.findViewById(R.id.imageView);
        viewHolder.textView = view.findViewById(R.id.textView);

        view.setTag(viewHolder);
        view.setOnClickListener(onClickListener);

        return viewHolder;
    }

    public View inflateView(ViewGroup group){
        LayoutInflater inflater = getInflater();
        return inflater.inflate(getItemResId(), group, false);
    }
    public LayoutInflater getInflater(){
        return (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getItemResId() {
        return itemResId;
    }

    public Context getContext() {
        return context;
    }


    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        this.notifyDataSetChanged();
    }
    public void clearItems(){
        this.items.clear();
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }
}
