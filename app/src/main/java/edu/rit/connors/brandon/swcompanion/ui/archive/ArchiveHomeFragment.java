package edu.rit.connors.brandon.swcompanion.ui.archive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.network.source.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.ui.archive.fragment.WookieepediaFragment;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

public class ArchiveHomeFragment extends Fragment {

    protected GridView gridView;
    protected GridListAdapter<IDataSource<ArchiveArticle>> adapter;
    protected static final Fragment[] fragments  = new Fragment[]{
            new WookieepediaFragment()
    };
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        gridView = view.findViewById(R.id.grid_view);
        adapter = new ArchiveHomeAdapter(getActivity(), fragments);
        gridView.setAdapter(adapter);
        adapter.setItems(new ArrayList<IDataSource<ArchiveArticle>>(){{
            add(new Wookieepedia());}});
        return view;
    }
}
