package rachma.tn.team.binary.rachma.belote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rachma.tn.team.binary.rachma.ChooseGame;
import rachma.tn.team.binary.rachma.R;

public class Winner extends AppCompatActivity {
    String WinnerTeam, Winner1, Winner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        setContentView(R.layout.belote_activity_winner);
        WinnerTeam = getIntent().getExtras().getString("WinnerTeam");
        Winner1 = getIntent().getExtras().getString("Winner1");
        Winner2 = getIntent().getExtras().getString("Winner2");
        Log.i(WinnerTeam, "winnteam ");
        Log.i(Winner1, "winner1 ");
        Log.i(Winner2, "winner2 ");

        TextView winnerTeam = (TextView) findViewById(R.id.winnerteam);
        TextView winner1 = (TextView) findViewById(R.id.winner1);
        TextView winner2 = (TextView) findViewById(R.id.winner2);

        winnerTeam.setText(WinnerTeam);
        winner1.setText(Winner1);
        winner2.setText(Winner2);



        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), ChooseGame.class);
                startActivity(home);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
