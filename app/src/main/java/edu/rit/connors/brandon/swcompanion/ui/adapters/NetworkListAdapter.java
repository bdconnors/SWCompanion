package edu.rit.connors.brandon.swcompanion.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.WebViewActivity;
import edu.rit.connors.brandon.swcompanion.models.PageItem;
import edu.rit.connors.brandon.swcompanion.util.HttpRequestClient;
import edu.rit.connors.brandon.swcompanion.ui.adapters.NetworkListAdapter.ViewHolder;

public class NetworkListAdapter extends Adapter<ViewHolder> implements OnClickListener {
    protected final Context context;
    protected ArrayList<PageItem> items;

    public NetworkListAdapter(Context context, ArrayList<PageItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onClick(View view) {

        int position = (int) view.getTag();
        PageItem item = getItem(position);

        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebViewActivity.URL_EXTRA, item.getPageURL());

        context.startActivity(intent);
    }
    @Override
    public void onBindViewHolder(NetworkListAdapter.ViewHolder viewHolder, final int position) {

        PageItem item = items.get(position);
        HttpRequestClient client = HttpRequestClient.getInstance(context);

        client.loadImageView(item.getImgURL(),viewHolder.getImageView());
        viewHolder.getTextView().setText(item.getTitle());
        viewHolder.itemView.setTag(position);
        viewHolder.itemView.setOnClickListener(this);
    }

    public void setItems(ArrayList<PageItem> items){
        this.items = items;
        this.notifyDataSetChanged();
    }
    public void clear(){
        items = new ArrayList<>();
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public PageItem getItem(int position){
        return items.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            textView = view.findViewById(R.id.textView);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }

    }
}
