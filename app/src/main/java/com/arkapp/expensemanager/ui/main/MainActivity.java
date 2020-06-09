package com.arkapp.expensemanager.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.arkapp.expensemanager.R;

import static androidx.navigation.ActivityKt.findNavController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the navigation component, Used to open different screen
        NavController navController = findNavController(this, R.id.fragment);

        AppBarConfiguration configuration = (new AppBarConfiguration.Builder(new int[]{R.id.homeFragment})).build();
        NavigationUI.setupActionBarWithNavController(this, navController, configuration);

        findNavController(this, R.id.fragment)
                .addOnDestinationChangedListener((controller, destination, arguments) -> {
                    if (destination.getId() != R.id.splashFragment && destination.getId() != R.id.signupFragment)
                        getSupportActionBar().show();
                    else
                        getSupportActionBar().hide();
                });
    }
}