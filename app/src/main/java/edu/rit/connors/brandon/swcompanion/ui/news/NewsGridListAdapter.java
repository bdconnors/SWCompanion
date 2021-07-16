package edu.rit.connors.brandon.swcompanion.ui.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.NewsArticle;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.network.service.NewsService;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

public class NewsGridListAdapter extends GridListAdapter<IDataSource<NewsArticle>> {
    public NewsGridListAdapter(Context context){
        super(context, R.layout.grid_list_item);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        IDataSource<NewsArticle> source = getItem(position);
        ViewHolder viewHolder;
        if(view == null){
            view = inflateView(viewGroup);
            viewHolder = makeViewHolder(view, v -> {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        new NewsNetworkRecyclerFragment(new NewsService(source))
                ).commit();
            });
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(source.getTitle());
        viewHolder.imageView.setImageResource(source.getLogoId());


        return view;
    }

    public FragmentActivity getActivity() {
        return (FragmentActivity) getContext();
    }
}
