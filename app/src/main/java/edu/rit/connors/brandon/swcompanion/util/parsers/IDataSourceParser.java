package edu.rit.connors.brandon.swcompanion.util.parsers;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.ArrayList;

import edu.rit.connors.brandon.swcompanion.models.PageItem;
import edu.rit.connors.brandon.swcompanion.util.DataSourceConstants.DataPage;

public interface IDataSourceParser {
    PageItem parse(Element element, DataPage dataPage);
    ArrayList<PageItem> parse(Document doc, DataPage dataPage);
}
