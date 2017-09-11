package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import rachma.tn.team.binary.rachma.belote.BeloteSetting;
import rachma.tn.team.binary.rachma.rummy.RummySetting;

public class MainActivity extends AppCompatActivity {

    TextView rummy, belote, settings;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        rummy = (TextView) findViewById(R.id.rummy_navigation_drawer);
        belote = (TextView) findViewById(R.id.belote_navigation_drawer);
        settings = (TextView) findViewById(R.id.settings_navigation_drawer);


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
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_drawer);
                mDrawerLayout.closeDrawer(navigationView);
            }
        });
    }
}
