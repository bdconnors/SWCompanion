package edu.rit.connors.brandon.swcompanion.ui.holonet;

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
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.network.source.starwars.StarWars;
import edu.rit.connors.brandon.swcompanion.ui.sources.SWOfficialHoloNet;
import edu.rit.connors.brandon.swcompanion.ui.util.adapter.GridListAdapter;

public class HoloNetHomeFragment extends Fragment {

    protected GridView gridView;
    protected GridListAdapter<DataSource> adapter;
    protected Fragment[] fragments;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_list_fragment, container, false);
        fragments = new Fragment[]{ new SWOfficialHoloNet() };
        gridView = view.findViewById(R.id.grid_view);
        adapter = new HoloNetHomeAdapter(getActivity(), fragments);
        gridView.setAdapter(adapter);
        adapter.setItems(new ArrayList<DataSource>(){{
            add(new StarWars()); }});
        return view;
    }

}
