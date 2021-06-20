package edu.rit.connors.brandon.swcompanion;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import edu.rit.connors.brandon.swcompanion.ui.wiki.WikiHome;
import edu.rit.connors.brandon.swcompanion.ui.wiki.WikiSearch;
import edu.rit.connors.brandon.swcompanion.parsers.WikiDataSourceParser;

public class WikiActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    Toolbar toolbar;
    SearchView searchView;
    FragmentManager fragmentManager;
    WikiSearch searchFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);
        searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(this);
        fragmentManager = getSupportFragmentManager();
        searchFragment = new WikiSearch(new WikiDataSourceParser());
        initToolbar();
        displayHome();
    }
    public void displayHome(){
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new WikiHome()).commit();
    }
    public void displaySearch(){
        fragmentManager.beginTransaction().replace(R.id.fragment_container, searchFragment).commit();
    }
    public void initToolbar(){
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        searchFragment.submitSearch();
        searchView.clearFocus();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String queryText) {
        searchFragment.setQueryText(queryText);
        if(queryText.isEmpty()){
            displayHome();
        }else{
            displaySearch();
        }
        return true;
    }
}
