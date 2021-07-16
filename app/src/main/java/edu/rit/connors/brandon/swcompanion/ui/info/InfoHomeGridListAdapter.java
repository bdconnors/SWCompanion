package edu.rit.connors.brandon.swcompanion.ui.info;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.InfoArticle;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

public class InfoHomeGridListAdapter extends GridListAdapter<IDataSource<InfoArticle>>{

    public InfoHomeGridListAdapter(Context context) {
        super(context, R.layout.grid_list_item);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        IDataSource<InfoArticle> source = getItem(position);
        ViewHolder viewHolder;
        if(view == null) {
            view = inflateView(viewGroup);
            viewHolder = makeViewHolder(view, v -> {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        new WookieepediaFragment()
                ).commit();
            });
        }else{
            viewHolder = (GridListAdapter.ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(source.getTitle());
        viewHolder.imageView.setImageResource(source.getLogoId());


        return view;
    }

    public FragmentActivity getActivity(){
        return (FragmentActivity) getContext();
    }
}

