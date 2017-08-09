package com.example.aliha_000.whats_monitor;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);


        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_menu);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case (R.id.nav_account):
                        Intent accountActivity = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(accountActivity);
                        break;
                    case (R.id.nav_settings):
                        Intent settingsActivity = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(settingsActivity);
                        break;
                    case (R.id.nav_logout):
                        Intent logoutActivity = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(logoutActivity);
                        break;
                    case (R.id.nav_monitor):
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
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void onClickStart(View view) {
        Context main = getApplicationContext();
        CharSequence sequence = "Started!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(main, sequence, duration);
        toast.show();
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        startActivity(sendIntent);
        PackageManager pm = getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            Log.w("APP", Arrays.toString(info.receivers));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
