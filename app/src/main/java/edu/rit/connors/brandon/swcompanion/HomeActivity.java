package edu.rit.connors.brandon.swcompanion;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import edu.rit.connors.brandon.swcompanion.core.fragments.SearchViewListFragment;
import edu.rit.connors.brandon.swcompanion.ui.news.NewsHome;
import edu.rit.connors.brandon.swcompanion.ui.wiki.WikiHome;
import edu.rit.connors.brandon.swcompanion.ui.wiki.parsers.WikiSearchParser;

public class HomeActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, BottomNavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    SearchView searchView;
    FragmentManager fragmentManager;
    SearchViewListFragment searchFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(this);
        fragmentManager = getSupportFragmentManager();
        searchFragment = new SearchViewListFragment(new WikiSearchParser());
        initToolbar();
        searchView.setVisibility(View.GONE);
        displayFragment(new NewsHome());
    }
    public void displayFragment(Fragment fragment){
        fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }

    public void initToolbar(){
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        searchFragment.load();
        searchView.clearFocus();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String queryText) {
        searchFragment.setQueryText(queryText);
        if(queryText.isEmpty()){
            displayFragment(new WikiHome());
        }else{
            displayFragment(searchFragment);
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.bottom_nav_1){
            searchView.setVisibility(View.GONE);
            displayFragment(new NewsHome());
            return true;
        }else if(id == R.id.bottom_nav_2){
            searchView.setVisibility(View.VISIBLE);
            displayFragment(new WikiHome());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
