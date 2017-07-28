package com.example.aliha_000.whats_monitor;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this , mDrawerLayout , R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem){
                switch (menuItem.getItemId()){
                    case(R.id.nav_account):
                        Intent accountActivity = new Intent(getApplicationContext(), FirstActivity.class);
                        startActivity(accountActivity);
                        break;
                    case(R.id.nav_settings):
                        Intent settingsActivity = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(settingsActivity);
                        break;
                    case(R.id.nav_logout):
                        Intent logoutActivity = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(logoutActivity);
                        break;
                    case(R.id.nav_monitor):
                        Intent monitorActivity = new Intent(getApplicationContext(), FourthActivity.class);
                        startActivity(monitorActivity);
                        break;


                }
                return true;
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       if (mToggle.onOptionsItemSelected(item)){

           return true;
       }

        return super.onOptionsItemSelected(item);
    }
}
