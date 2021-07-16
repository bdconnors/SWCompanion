package edu.rit.connors.brandon.swcompanion.network.service;

import edu.rit.connors.brandon.swcompanion.domain.model.HoloNetArticle;
import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;

public class HoloNetService extends NetworkService<HoloNetArticle> {
    public HoloNetService(IDataSource<HoloNetArticle> dataSource) {
        super(dataSource);
    }
}
