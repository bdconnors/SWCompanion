package edu.rit.connors.brandon.swcompanion.ui.lists;

public abstract class SearchViewList extends RecyclerList {

    protected String queryText;

    public SearchViewList(String queryText) {
        this.queryText = queryText;
    }

    public SearchViewList(){}

    public String getQueryText() {
        return queryText;
    }

    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public abstract void submitSearch();
}
