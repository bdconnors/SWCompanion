package edu.rit.connors.brandon.swcompanion;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import edu.rit.connors.brandon.swcompanion.domain.model.Article;
import edu.rit.connors.brandon.swcompanion.constants.AppPage;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<AppPage> activePage = new MutableLiveData<>();
    private final MutableLiveData<String> searchViewText = new MutableLiveData<>();
    private final MutableLiveData<List<Article>> searchResults = new MutableLiveData<>();



    public MutableLiveData<AppPage>getActivePage(){
        return activePage;
    }

    public void setActivePage(AppPage page){
        activePage.setValue(page);
    }

    public MutableLiveData<String> getSearchViewText() {
        return searchViewText;
    }

    public void setSearchViewText(String value) {
        this.searchViewText.setValue(value);
    }

    public MutableLiveData<List<Article>> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Article> results){
        searchResults.setValue(results);
    }

}
