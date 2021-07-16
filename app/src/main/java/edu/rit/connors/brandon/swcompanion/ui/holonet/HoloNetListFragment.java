package edu.rit.connors.brandon.swcompanion.ui.holonet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.rit.connors.brandon.swcompanion.domain.model.HoloNetArticle;
import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkRecyclerFragment;

public class HoloNetListFragment extends NetworkRecyclerFragment<HoloNetArticle> {

    public final int sectionId;
    public HoloNetListFragment(INetworkService<HoloNetArticle> service, int sectionId) {
        super(service);
        this.sectionId = sectionId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.setAdapter(new HoloNetListAdapter(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        load();
    }

    public void load() {
        getService().load(this, sectionId);
    }

    @Override
    public void onRefresh() {
        load();
    }
}
