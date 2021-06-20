package edu.rit.connors.brandon.swcompanion.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.NetworkItem;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants;

public class NewsDataSourceParser implements IDataSourceParser {
    @Override
    public NetworkItem parse(Element element, DataSourceConstants.DataPage dataPage) {
        return null;
    }

    @Override
    public ArrayList<NetworkItem> parse(Document doc, DataSourceConstants.DataPage dataPage) {
        return null;
    }
}
