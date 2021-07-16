package edu.rit.connors.brandon.swcompanion.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import javax.sql.DataSource;

import edu.rit.connors.brandon.swcompanion.R;
import edu.rit.connors.brandon.swcompanion.domain.model.NewsArticle;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.domain.source.StarWarsNews;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

import static edu.rit.connors.brandon.swcompanion.constants.WebSource.NEWS_STARWARS;

public class NewsHomeFragment extends Fragment{

    protected GridView gridView;
    protected GridListAdapter<IDataSource<NewsArticle>> adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        gridView = view.findViewById(R.id.grid_view);
        adapter = new NewsGridListAdapter(getActivity());
        gridView.setAdapter(adapter);
        adapter.setItems(new ArrayList<IDataSource<NewsArticle>>(){{
            add(new StarWarsNews()); }});
        return view;
    }
    /**public static final WebSource[] sources = new WebSource[]{NEWS_STARWARS};
    public static final Fragment[] fragments = new Fragment[]{
            new NewsNetworkRecyclerFragment(new StarWarsService(), sources[0])
    };
    public NewsHomeFragment() {
        super(sources, fragments);
    }**/

}
