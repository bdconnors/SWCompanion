package edu.rit.connors.brandon.swcompanion.ui.archive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkGridFragment;

public class ArchiveGridFragment extends NetworkGridFragment<Article> {
    private final int pageId;
    public ArchiveGridFragment(INetworkService<Article> service, int pageId){
        super(service);
        this.pageId = pageId;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.setAdapter(new ArchiveGridAdapter(getActivity()));
        getService().load(this, pageId);
        return view;
    }

    @Override
    public void onRefresh() {
        getService().load(this, pageId);
    }
}
