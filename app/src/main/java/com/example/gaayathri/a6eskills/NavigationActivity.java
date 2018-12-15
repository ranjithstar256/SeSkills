package com.example.gaayathri.a6eskills;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frm,new HomeFragment()).addToBackStack(null).commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (id == R.id.nav_schedule) {
            fragmentTransaction.replace(R.id.frm,new ScheduleFragment()).commit();
            Toast.makeText(this, "Your schedule here !!!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_availability) {
            fragmentTransaction.replace(R.id.frm,new AvailabilityFragment()).addToBackStack(null).commit();
            Toast.makeText(this, "Your availability here !!!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_points) {
            fragmentTransaction.replace(R.id.frm,new PointsFragment()).addToBackStack(null).commit();
            Toast.makeText(this, "Your points here !!!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_rating) {
            fragmentTransaction.replace(R.id.frm,new RatingFragment()).addToBackStack(null).commit();
            Toast.makeText(this, "Your ratings here !!!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            fragmentTransaction.replace(R.id.frm,new SettingsFragment()).addToBackStack(null).commit();
            Toast.makeText(this, "Your settings here !!!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_aboutus) {
            fragmentTransaction.replace(R.id.frm,new AboutusFragment()).addToBackStack(null).commit();
            Toast.makeText(this, "About 6eSkills here !!!", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_home) {
            fragmentTransaction.replace(R.id.frm,new HomeFragment()).addToBackStack(null).commit();
            Toast.makeText(this, "About 6eSkills here !!!", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void fghj(MenuItem item) {

    }
}
