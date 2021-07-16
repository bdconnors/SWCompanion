package edu.rit.connors.brandon.swcompanion.ui.archive;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.WebViewActivity;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

public class ArchiveGridAdapter extends GridListAdapter<ArchiveArticle>  {

    public ArchiveGridAdapter(Activity activity) {
        super(activity, R.layout.grid_list_item);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        Article article = getItem(position);
        Log.d("InfoGridListAdapter", "article: " + article.url);
        ViewHolder viewHolder;
        if(view == null) {
            view = inflateView(viewGroup);
            viewHolder = makeViewHolder(view, v -> {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.URL_EXTRA, article.url);
                getContext().startActivity(intent);
            });
        }else{
            viewHolder = (GridListAdapter.ViewHolder) view.getTag();
        }

        if(article.image.isEmpty()){
            viewHolder.imageView.setImageResource(R.drawable.baseline_broken_image_white_24dp);
        }else {
            Picasso.get()
                    .load(article.image)
                    .error(R.drawable.baseline_broken_image_white_24dp)
                    .into(viewHolder.imageView);
        }

        viewHolder.textView.setText(article.title);

        return view;
    }


    public Activity getActivity(){
        return (Activity) getContext();
    }


}
