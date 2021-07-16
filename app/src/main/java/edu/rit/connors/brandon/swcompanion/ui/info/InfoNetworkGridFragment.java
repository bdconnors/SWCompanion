package edu.rit.connors.brandon.swcompanion.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.rit.connors.brandon.swcompanion.constants.WebSource;
import edu.rit.connors.brandon.swcompanion.domain.model.InfoArticle;
import edu.rit.connors.brandon.swcompanion.network.util.INetworkService;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkGridFragment;

public class InfoNetworkGridFragment extends NetworkGridFragment<InfoArticle> {

    public InfoNetworkGridFragment(INetworkService<InfoArticle> service){
        super(service);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.setAdapter(new InfoGridListAdapter(getActivity()));
        getService().load(this);
        return view;
    }

    @Override
    public void onRefresh() {
        getService().load(this);
    }
}
