package edu.rit.connors.brandon.swcompanion.ui.archive;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

public class ArchiveHomeAdapter extends GridListAdapter<DataSource>{
    public final Fragment[] fragments;
    public ArchiveHomeAdapter(Context context, Fragment[] fragments) {
        super(context, R.layout.grid_list_item);
        this.fragments = fragments;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        DataSource source = getItem(position);
        ViewHolder viewHolder;
        if(view == null) {
            view = inflateView(viewGroup);
            viewHolder = makeViewHolder(view, v -> {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(
                        R.id.fragment_container,
                        fragments[position]
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
