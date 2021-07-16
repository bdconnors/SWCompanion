package edu.rit.connors.brandon.swcompanion.ui.holonet;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.WebViewActivity;
import edu.rit.connors.brandon.swcompanion.domain.model.HoloNetArticle;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.RecyclerListAdapter;

public class HoloNetListAdapter extends RecyclerListAdapter<HoloNetArticle> implements View.OnClickListener {

    public HoloNetListAdapter(Activity activity) {
        super(activity, R.layout.news_list_item);
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(listItemResId, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder)viewHolder;
        HoloNetArticle item = (HoloNetArticle) items.get(position);
        if(item.image.isEmpty()){
            holder.imageView.setImageResource(R.drawable.baseline_broken_image_white_24dp);
        }else {
            Picasso.get()
                    .load(item.image)
                    .error(R.drawable.baseline_broken_image_white_24dp)
                    .into(holder.imageView);
        }
        holder.getPrimaryTextView().setText(item.title);
        holder.getBodyTextView().setText(item.body);
        holder.getAuthorTextView().setText(item.author);
        holder.getFooterTextView().setText(item.footer);
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int position = (int) view.getTag();
        HoloNetArticle item = getItem(position);

        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebViewActivity.URL_EXTRA, item.url);

        activity.startActivity(intent);
    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    public int getListItemResId() {
        return listItemResId;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView primaryTextView;
        private final TextView bodyTextView;
        private final TextView authorTextView;
        private final TextView footerTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            primaryTextView = view.findViewById(R.id.primaryTextView);
            bodyTextView = view.findViewById(R.id.bodyTextView);
            authorTextView = view.findViewById(R.id.authorTextView);
            footerTextView = view.findViewById(R.id.footerTextView);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getPrimaryTextView() {
            return primaryTextView;
        }

        public TextView getBodyTextView() {
            return bodyTextView;
        }

        public TextView getFooterTextView() {
            return footerTextView;
        }

        public TextView getAuthorTextView() {
            return authorTextView;
        }
    }

}
