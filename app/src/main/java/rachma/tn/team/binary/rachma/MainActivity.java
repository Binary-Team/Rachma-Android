package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import rachma.tn.team.binary.rachma.belote.BeloteSetting;
import rachma.tn.team.binary.rachma.rummy.RummySetting;

public class MainActivity extends AppCompatActivity {

    LinearLayout rummy, belote, settings, home;
    ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rummy = (LinearLayout) findViewById(R.id.rummy_navigation_drawer);
        belote = (LinearLayout) findViewById(R.id.belote_navigation_drawer);
        settings = (LinearLayout) findViewById(R.id.settings_navigation_drawer);
        home = (LinearLayout) findViewById(R.id.home_navigation_drawer);


        // insert choose game fragment
        Fragment fragment = new ChooseGame();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_drawer);
        setActiveMenu(home);
        setInctiveMenu(rummy);
        setInctiveMenu(settings);
        setInctiveMenu(belote);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.save_score, R.string.score) {

            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);



        rummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new RummySetting();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
                NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_drawer);
                mDrawerLayout.closeDrawer(navigationView);
                setActiveMenu(rummy);
                setInctiveMenu(belote);
                setInctiveMenu(home);
            }
        });

        belote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new BeloteSetting();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
                NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_drawer);
                mDrawerLayout.closeDrawer(navigationView);
                setActiveMenu(belote);
                setInctiveMenu(rummy);
                setInctiveMenu(home);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_drawer);
                mDrawerLayout.closeDrawer(navigationView);
                setActiveMenu(home);
                setInctiveMenu(rummy);
                setInctiveMenu(belote);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new ChooseGame();
                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit();
                NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_drawer);
                mDrawerLayout.closeDrawer(navigationView);
                setActiveMenu(home);
                setInctiveMenu(rummy);
                setInctiveMenu(belote);
            }
        });


    }

    private void setActiveMenu(LinearLayout activeLinearLayout) {
        activeLinearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
    }

    private void setInctiveMenu(LinearLayout InactiveLinearLayout) {
        InactiveLinearLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
