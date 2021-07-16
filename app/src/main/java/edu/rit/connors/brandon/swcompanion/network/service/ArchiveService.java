package edu.rit.connors.brandon.swcompanion.network.service;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.network.source.IDataSource;

public class ArchiveService extends NetworkService<ArchiveArticle> {
    public ArchiveService(IDataSource<ArchiveArticle> dataSource) {
        super(dataSource);
    }

}
