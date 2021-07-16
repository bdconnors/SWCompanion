package edu.rit.connors.brandon.swcompanion;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

import java.util.HashMap;

import edu.rit.connors.brandon.swcompanion.constants.AppPage;
import edu.rit.connors.brandon.swcompanion.constants.WebSource;
import edu.rit.connors.brandon.swcompanion.ui.news.NewsHomeFragment;
import edu.rit.connors.brandon.swcompanion.ui.info.InfoHomeFragment;

public class HomeActivity extends AppCompatActivity implements OnQueryTextListener, OnNavigationItemSelectedListener {

    SharedViewModel viewModel;
    Toolbar toolbar;
    SearchView searchView;
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupBottomNav();
        setupSearchView();
        setupToolbar();
        setupFragmentManager();
        setupViewModel();
        displayPage(AppPage.NEWS);

    }

    public void displayPage(AppPage page){

        Fragment fragment = new NewsHomeFragment();
        switch (page){
            case NEWS:
                fragment = new NewsHomeFragment();
                break;
            case INFO:
                fragment = new InfoHomeFragment();
                break;
            default:
        }

        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    public void setupViewModel(){
        viewModel = new ViewModelProvider(this).get(SharedViewModel.class);
        viewModel.getActivePage().observe(this, item -> {
            Log.d("HomeActivity", "onViewCreated: " + item.toString());
        });
        viewModel.setActivePage(AppPage.NEWS);
    }

    public void setupFragmentManager(){
        fragmentManager = getSupportFragmentManager();
        searchView.setVisibility(View.GONE);
    }

    public void setupSearchView(){
        searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(this);
    }

    public void setupBottomNav(){
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    public void setupToolbar(){
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String queryText) {
        viewModel.getSearchViewText().setValue(queryText);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.bottom_nav_1){
            viewModel.getActivePage().setValue(AppPage.NEWS);
            displayPage(AppPage.NEWS);
            return true;
        }else if(id == R.id.bottom_nav_2){
            viewModel.getActivePage().setValue(AppPage.INFO);
            displayPage(AppPage.INFO);
            return true;
        }else{
            return false;
        }
    }
}
