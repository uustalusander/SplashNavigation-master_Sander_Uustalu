package com.example.sander.splashnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {  // MainAcivity meetod

    private DrawerLayout mDrawerLayout; //Muutuja lisamine
    private ActionBarDrawerToggle mToggle; // Muutuja lisamine
    Button mbutton;
    private Toolbar mToolbar; // Muutuja lisamine

    //TODO: add fragment variables
    FragmentTransaction fragmentTransaction; // Muutuja lisamine
    NavigationView navigationView; // Muutuja lisamine

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Võtab layoutiks activity_home

        mToolbar = (Toolbar) findViewById(R.id.nav_action); // Otsib nav_actioni projektist üles
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout); // Otsib drawerLayout projektist üles
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close); // Lisab mTogglele Open ja Close võimaluse

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState(); // Sünkroniseerib ära mToggle muutuja
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Fragment alustab tegevust
        fragmentTransaction.add(R.id.main_container, new HomeFragment()); // Muudab hetkel oleva pildi HomeFragmenti vastu
        fragmentTransaction.commit(); //Ühendab

        getSupportActionBar().setTitle("Home fragment...."); // Muudab pealkirja Home fragment vastu


        navigationView = (NavigationView)findViewById(R.id.navigation_menu); // Otsib projektist navigation_menu üles ja paneb selle muutujale
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) { // Meetod
                switch (item.getItemId()){ // Muudab esemeid kui seda valitakse
                    case R.id.nav_home_fragment: // Kui valitakse R.id.nav_home_fragment, siis juhtub all olev kood
                        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Fragment alustab
                        fragmentTransaction.replace(R.id.main_container,new HomeFragment()); // Muudab hetkel oleva pildi HomeFragmenti vastu
                        fragmentTransaction.commit(); // Ühendab
                        getSupportActionBar().setTitle("Home fragment"); // Muudab pealkirja Home fragmentiks
                        item.setChecked(true); // item kontrollitakse ja  muudetakse trueks
                        mDrawerLayout.closeDrawers();
                        break; // Peatab
                    case R.id.nav_email_fragment: // Kui valitakse R.id.nav_email_fragment, siis juhtub all olev kood
                        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Fragment alustab
                        fragmentTransaction.replace(R.id.main_container,new EmailFragment()); // Muudab hetkel oleva pildi EmailFragmenti vastu
                        fragmentTransaction.commit(); // Ühendab
                        getSupportActionBar().setTitle("Email fragment"); // Muudab pealkirja Email fragmentiks
                        item.setChecked(true); // item kontrollitakse ja  muudetakse trueks
                        mDrawerLayout.closeDrawers(); // mDrawerLayout pandakse kinni
                        break;
                    case R.id.nav_calendar_fragment: // Kui valitakse R.id.nav_calendar_fragment, siis juhtub all olev kood
                        fragmentTransaction = getSupportFragmentManager().beginTransaction(); // Fragment alustab
                        fragmentTransaction.replace(R.id.main_container,new CalendarFragment());  // Muudab hetkel oleva pildi CalendarFragmenti vastu
                        fragmentTransaction.commit(); // Ühendab
                        getSupportActionBar().setTitle("Calendar fragment"); // Muudab pealkirja Calendar fragmentiks
                        item.setChecked(true); // item kontrollitakse ja  muudetakse trueks
                        mDrawerLayout.closeDrawers(); // mDrawerLayout pandakse kinni
                        break; // Peatab
                }
                return true; // Väljastab true valiku
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (mToggle.onOptionsItemSelected(item)){  // Juhul kui mToggle item on valitud, siis returnib true
            return true;
        }
        return super.onOptionsItemSelected(item); // Muidu returnib super.onOptionsItemSelected(item)
    }
}
