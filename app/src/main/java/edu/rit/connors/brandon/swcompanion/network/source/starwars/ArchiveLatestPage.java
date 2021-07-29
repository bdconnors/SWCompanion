package edu.rit.connors.brandon.swcompanion.network.source.starwars;

import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.ArchiveArticle;
import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.network.source.SourcePage;

public class ArchiveLatestPage extends SourcePage {
    public ArchiveLatestPage() {
        super(1,"Latest", "https://www.starwars.com/databank");
    }

    @Override
    public Article parseElement(Element element) {
        return null;
    }

    @Override
    public List<Article> parse(Document document) {
        List<Article> results = new ArrayList<>();
        Elements sections = document.select("div#body-wrapper > div#burger-container > div#main-body > div#main > article#burger > section.bound > div.bound");

        Element latestSection = null;
        Element header;

        for(Element sec : sections){
            header = sec.selectFirst("div.module_header > h2.module_title");
            if(header != null && header.text().equals("The Latest")){
                latestSection = sec;
                break;
            }
        }

        if(latestSection != null){
            Elements itemContainers = latestSection.select("div.blocks-bound > div.blocks-container > ul.blocks-list-view > div");
            Elements items = itemContainers.select("div.databank-content > div.building-block > div.building-block-aspect > div.building-block-padding > div.building-block-wrapper");

            Element curItemAnchor;
            String image;
            String title;
            String url;
            for(Element item : items){
                curItemAnchor = item.selectFirst("div.image-wrapper > div.aspect > a");
                image = curItemAnchor.selectFirst("img").attr("src");
                Log.d("ArchiveLatestPage", "image: "+image);
                title = curItemAnchor.selectFirst("img").attr("alt");
                Log.d("ArchiveLatestPage", "title: "+title);
                url = curItemAnchor.attr("href");
                Log.d("ArchiveLatestPage", "url: " +url);
                results.add(new ArchiveArticle(url, title, image));
            }

        }

        return results;
    }
}
