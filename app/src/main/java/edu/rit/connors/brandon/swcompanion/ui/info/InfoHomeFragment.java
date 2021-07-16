package edu.rit.connors.brandon.swcompanion.ui.info;

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
import edu.rit.connors.brandon.swcompanion.domain.model.InfoArticle;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.domain.source.Wookieepedia;
import edu.rit.connors.brandon.swcompanion.ui.news.NewsGridListAdapter;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

import static edu.rit.connors.brandon.swcompanion.constants.WebSource.WOOKIEEPEDIA;

public class InfoHomeFragment extends Fragment {

    protected GridView gridView;
    protected GridListAdapter<IDataSource<InfoArticle>> adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        gridView = view.findViewById(R.id.grid_view);
        adapter = new InfoHomeGridListAdapter(getActivity());
        gridView.setAdapter(adapter);
        adapter.setItems(new ArrayList<IDataSource<InfoArticle>>(){{
            add(new Wookieepedia());}});
        return view;
    }
    /**private static final WebSource[] sources = new WebSource[]{
            WIKI_TRENDING,
            WIKI_POPULAR
    };

    private static final Fragment[] fragments = new Fragment[]{
            new InfoNetworkGridFragment(new WikiService(), sources[0]),
            new InfoNetworkGridFragment(new WikiService(), sources[1])
    };

    public InfoHomeFragment() {
        super(sources,fragments);
    }**/
}
