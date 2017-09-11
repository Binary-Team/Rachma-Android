package rachma.tn.team.binary.rachma.rummy;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import rachma.tn.team.binary.rachma.R;

public class RummyGameEnded extends AppCompatActivity {

    Integer playersNumber, finalScore;
    String firstPlayerName, secondPlayerName, thirdPlayerName, fourthPlayerName;
    Integer firstPlayerScore, secondPlayerScore, thirdPlayerScore, fourthPlayerScore;
    TextView player1nameTV, player2nameTV, player3nameTV, player4nameTV;
    TextView player1Score, player2Score, player3Score, player4Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rummy_activity_rummy_game_ended);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // player1
        player1nameTV = (TextView) findViewById(R.id.player1nameScoreboard);
        player1Score = (TextView) findViewById(R.id.player1scoreScoreboard);
        // player2
        player2nameTV = (TextView) findViewById(R.id.player2nameScoreboard);
        player2Score = (TextView) findViewById(R.id.player2scoreScoreboard);
        //player 3
        player3nameTV = (TextView) findViewById(R.id.player3nameScoreboard);
        player3Score = (TextView) findViewById(R.id.player3scoreScoreboard);
        //player 4
        player4nameTV = (TextView) findViewById(R.id.player4nameScoreboard);
        player4Score = (TextView) findViewById(R.id.player4scoreScoreboard);

        // get final score
        finalScore = getIntent().getExtras().getInt("finalScore");

        // get players number
        playersNumber = getIntent().getExtras().getInt("playersNumber");


        // get players names
        switch (playersNumber) {

            case 2:
                firstPlayerName = getIntent().getExtras().getString("firstPlayerName");
                secondPlayerName = getIntent().getExtras().getString("secondPlayerName");
                firstPlayerScore = getIntent().getExtras().getInt("firstPlayerScore");
                secondPlayerScore = getIntent().getExtras().getInt("secondPlayerScore");
                // first player
                player1nameTV.setText(firstPlayerName);
                player1Score.setText(firstPlayerScore.toString());
                //second player
                player2nameTV.setText(secondPlayerName);
                player2Score.setText(secondPlayerScore.toString());
                // hide other players
                player3nameTV.setVisibility(View.GONE);
                player3Score.setVisibility(View.GONE);
                player4nameTV.setVisibility(View.GONE);
                player4Score.setVisibility(View.GONE);
                break;
            case 3:
                firstPlayerName = getIntent().getExtras().getString("firstPlayerName");
                secondPlayerName = getIntent().getExtras().getString("secondPlayerName");
                thirdPlayerName = getIntent().getExtras().getString("thirdPlayerName");
                firstPlayerScore = getIntent().getExtras().getInt("firstPlayerScore");
                secondPlayerScore = getIntent().getExtras().getInt("secondPlayerScore");
                thirdPlayerScore = getIntent().getExtras().getInt("thirdPlayerScore");

                // first player
                player1nameTV.setText(firstPlayerName);
                player1Score.setText(firstPlayerScore.toString());
                //second player
                player2nameTV.setText(secondPlayerName);
                player2Score.setText(secondPlayerScore.toString());
                //third player
                player3nameTV.setText(thirdPlayerName);
                player3Score.setText(thirdPlayerScore.toString());
                // hide other players
                player4nameTV.setVisibility(View.GONE);
                player4Score.setVisibility(View.GONE);

                break;
            case 4:
                firstPlayerName = getIntent().getExtras().getString("firstPlayerName");
                secondPlayerName = getIntent().getExtras().getString("secondPlayerName");
                thirdPlayerName = getIntent().getExtras().getString("thirdPlayerName");
                fourthPlayerName = getIntent().getExtras().getString("fourthPlayerName");
                firstPlayerScore = getIntent().getExtras().getInt("firstPlayerScore");
                secondPlayerScore = getIntent().getExtras().getInt("secondPlayerScore");
                thirdPlayerScore = getIntent().getExtras().getInt("thirdPlayerScore");
                fourthPlayerScore = getIntent().getExtras().getInt("fourthPlayerScore");

                // first player
                player1nameTV.setText(firstPlayerName);
                player1Score.setText(firstPlayerScore.toString());
                //second player
                player2nameTV.setText(secondPlayerName);
                player2Score.setText(secondPlayerScore.toString());
                //third player
                player3nameTV.setText(thirdPlayerName);
                player3Score.setText(thirdPlayerScore.toString());
                //fourth player
                player4nameTV.setText(fourthPlayerName);
                player4Score.setText(fourthPlayerScore.toString());

                break;

        }

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
