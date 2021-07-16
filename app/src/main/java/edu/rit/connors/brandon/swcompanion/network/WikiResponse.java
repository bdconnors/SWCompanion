package edu.rit.connors.brandon.swcompanion.network;

import java.util.ArrayList;
import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.InfoArticle;

public class WikiResponse {

    public int count = 0;
    public int nextPage = -1;
    public int prevPage = -1;
    public List<InfoArticle> results = new ArrayList<>();

}
