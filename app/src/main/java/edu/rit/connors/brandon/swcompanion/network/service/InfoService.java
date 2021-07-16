package edu.rit.connors.brandon.swcompanion.network.service;

import edu.rit.connors.brandon.swcompanion.domain.model.InfoArticle;
import edu.rit.connors.brandon.swcompanion.domain.source.IDataSource;

public class InfoService extends NetworkService<InfoArticle> {
    public InfoService(IDataSource<InfoArticle> dataSource) {
        super(dataSource);
    }

}
