package edu.rit.connors.brandon.swcompanion.parsers;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.NetworkItem;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants.DataPage;

public interface IDataSourceParser {
    NetworkItem parse(Element element, DataPage dataPage);
    ArrayList<NetworkItem> parse(Document doc, DataPage dataPage);
}
