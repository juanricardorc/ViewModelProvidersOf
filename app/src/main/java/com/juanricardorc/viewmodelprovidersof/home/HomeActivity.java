package com.juanricardorc.viewmodelprovidersof.home;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.juanricardorc.viewmodelprovidersof.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView navView;
    private AppBarConfiguration appBarConfiguration;
    private HomeViewModelFactory homeViewModelFactory;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupBottomNavigationView();
        setupAppBarConfiguration();
        setupNavController();
        setupViewModel();
    }

    private void setupBottomNavigationView() {
        navView = findViewById(R.id.nav_view);
    }

    private void setupAppBarConfiguration() {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
    }

    private void setupNavController() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    private void setupViewModel() {
        homeViewModelFactory = new HomeViewModelFactory(getBaseContext());
        homeViewModel = new ViewModelProvider(getViewModelStore(), homeViewModelFactory)
                .get(HomeViewModel.class);
    }

}
