package edu.rit.connors.brandon.swcompanion.ui.archive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.service.ArchiveService;
import edu.rit.connors.brandon.swcompanion.network.service.INetworkService;
import edu.rit.connors.brandon.swcompanion.network.source.DataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkGridFragment;

public class ArchiveGridFragment extends NetworkGridFragment<Article> {
    private static final ArchiveService service = new ArchiveService();
    public ArchiveGridFragment(DataSource source){
        super(source);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        this.setAdapter(new ArchiveGridAdapter(getActivity()));
        service.load(this, source);
        return view;
    }

    @Override
    public void onRefresh() {
        service.load(this, source);
    }
}
