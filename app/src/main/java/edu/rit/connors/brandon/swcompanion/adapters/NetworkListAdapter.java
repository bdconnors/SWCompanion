package edu.rit.connors.brandon.swcompanion.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.WebViewActivity;
import edu.rit.connors.brandon.swcompanion.models.NetworkItem;

public abstract class NetworkListAdapter extends Adapter<RecyclerView.ViewHolder> implements OnClickListener {
    protected final Context context;
    protected ArrayList<NetworkItem> items;

    public NetworkListAdapter(Context context, ArrayList<NetworkItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public void onClick(View view) {

        int position = (int) view.getTag();
        NetworkItem item = getItem(position);

        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebViewActivity.URL_EXTRA, item.getPageURL());

        context.startActivity(intent);
    }

    public void setItems(ArrayList<NetworkItem> items){
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

    public NetworkItem getItem(int position){
        return items.get(position);
    }

    /**public static class ViewHolder extends RecyclerView.ViewHolder {
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

    }**/
}
