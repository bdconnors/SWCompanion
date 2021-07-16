package edu.rit.connors.brandon.swcompanion.network.service;

import edu.rit.connors.brandon.swcompanion.domain.model.NewsArticle;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;
import edu.rit.connors.brandon.swcompanion.ui.util.fragment.NetworkList;

public class NewsService extends NetworkService<NewsArticle> {
    public NewsService(IDataSource<NewsArticle> dataSource) {
        super(dataSource);
    }
}
