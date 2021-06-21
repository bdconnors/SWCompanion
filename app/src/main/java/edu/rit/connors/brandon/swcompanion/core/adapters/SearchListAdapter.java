package edu.rit.connors.brandon.swcompanion.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.core.models.ListItem;
import edu.rit.connors.brandon.swcompanion.core.HttpRequestClient;

public class SearchListAdapter extends ListAdapter {

    public SearchListAdapter(Context context, ArrayList<ListItem> items) {
        super(context, items);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_list_item, viewGroup, false);

        return new SearchItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        SearchItemViewHolder holder = (SearchItemViewHolder) viewHolder;
        ListItem item = items.get(position);
        HttpRequestClient client = HttpRequestClient.getInstance();

        client.loadImageView(item.getImgURL(),holder.getImageView());
        holder.getTextView().setText(item.getTitle());
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }
    public static class SearchItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;

        public SearchItemViewHolder(@NonNull View view) {
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
