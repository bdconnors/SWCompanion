package edu.rit.connors.brandon.swcompanion.ui.adapters;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.WebViewActivity;
import edu.rit.connors.brandon.swcompanion.models.PageItem;
import edu.rit.connors.brandon.swcompanion.util.HttpRequestClient;

public class GridViewAdapter extends BaseAdapter implements View.OnClickListener {
    private Context ctx;
    public ArrayList<PageItem> items;
    public LayoutInflater inflater;

    // Gets the context so it can be used later
    public GridViewAdapter(Context ctx, ArrayList<PageItem> items) {
        this.ctx = ctx;
        this.items = items;
        this.inflater = ( LayoutInflater )ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    // Total number of things contained within the adapter
    public int getCount() {
        return items.size();
    }

    // Require for structure, not really used in my code.
    public PageItem getItem(int position) {
        return items.get(position);
    }

    // Require for structure, not really used in my code. Can
    // be used to get the id of an item in the adapter for
    // manual control.
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup) {
        PageItem item = items.get(position);

        ViewHolder view = null;
        if (convertView == null) {
            view = new ViewHolder();
            convertView = inflater.inflate(R.layout.grid_list_item,viewGroup,false);
            view.imageView=(ImageView)convertView.findViewById(R.id.imageView);
            view.textView =(TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(view);
            convertView.setContentDescription(String.valueOf(position));
            convertView.setOnClickListener(this);
        }
        else {
            view = (ViewHolder) convertView.getTag();
        }
        view.textView.setText(item.getTitle());
        HttpRequestClient.getInstance(ctx).loadImageView(item.getImgURL(), view.imageView);
        return convertView;
    }
    public void setItems(ArrayList<PageItem> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        int position = Integer.parseInt((String) view.getContentDescription());
        PageItem item = items.get(position);

        Intent intent = new Intent(ctx, WebViewActivity.class);
        intent.putExtra(WebViewActivity.URL_EXTRA, item.getPageURL());

        ctx.startActivity(intent);
    }

    public static class ViewHolder {
        public ImageView imageView;
        public TextView textView;

    }
}