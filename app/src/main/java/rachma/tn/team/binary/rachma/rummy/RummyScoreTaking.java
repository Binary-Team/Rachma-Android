package rachma.tn.team.binary.rachma.rummy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import rachma.tn.team.binary.rachma.R;
import rachma.tn.team.binary.rachma.SettingsActivity;
import rachma.tn.team.binary.rachma.adapter.RummyScoreHistoryAdapter;
import rachma.tn.team.binary.rachma.entity.RummyPlayer;
import rachma.tn.team.binary.rachma.entity.RummyRound;

public class RummyScoreTaking extends AppCompatActivity {

    static RummyRound rummyRounds;
    static Integer playersNumber;
    static String player1Name, player2Name, player3Name, player4Name;
    EditText player1Score, player2Score, player3Score, player4Score;
    TextView firstPlayer, secondPlayer, thirdPlayer, fourthPlayer;
    TextView player1nameTV, player2nameTV, player3nameTV, player4nameTV;
    TextView firstPlaceTV, secondPlaceTV, thirdPlaceTV, fourthPlaceTV;
    Button saveScore;
    Integer finalScore;
    HashMap<String, Integer> totalScores = new HashMap<>();
    CheckBox player1Lost, player2Lost, player3Lost, player4Lost;
    CheckBox player1Won, player2Won, player3Won, player4Won;
    HashMap<String, Integer> scoreOfLastRound = new HashMap<>();
    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rummy_activity_rummy_score_taking);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // get final score
        finalScore = getIntent().getExtras().getInt("finalScore");


        // get players number
        playersNumber = getIntent().getExtras().getInt("playersNumber");

        // players name
        player1nameTV = (TextView) findViewById(R.id.player1nameScoreTaking);
        player2nameTV = (TextView) findViewById(R.id.player2nameScoreTaking);
        player3nameTV = (TextView) findViewById(R.id.player3nameScoreTaking);
        player4nameTV = (TextView) findViewById(R.id.player4nameScoreTaking);

        // players score
        player1Score = (EditText) findViewById(R.id.player1ScoreScoreTaking);
        player2Score = (EditText) findViewById(R.id.player2ScoreScoreTaking);
        player3Score = (EditText) findViewById(R.id.player3ScoreScoreTaking);
        player4Score = (EditText) findViewById(R.id.player4ScoreScoreTaking);

        //  places textviews
        firstPlaceTV = (TextView) findViewById(R.id.firstPlace);
        secondPlaceTV = (TextView) findViewById(R.id.secondPlace);
        thirdPlaceTV = (TextView) findViewById(R.id.thirdPlace);
        fourthPlaceTV = (TextView) findViewById(R.id.fourthPlace);


        // get players names
        switch (playersNumber) {

            case 2:
                player1Name = getIntent().getExtras().getString("firstPlayerName");
                player2Name = getIntent().getExtras().getString("secondPlayerName");
                player1nameTV.setText(player1Name);
                player2nameTV.setText(player2Name);
                player1Score.setHint(player1Name + " " + getResources().getString(R.string.score));
                player2Score.setHint(player2Name + " " + getResources().getString(R.string.score));

                break;
            case 3:
                player1Name = getIntent().getExtras().getString("firstPlayerName");
                player2Name = getIntent().getExtras().getString("secondPlayerName");
                player3Name = getIntent().getExtras().getString("thirdPlayerName");
                player1nameTV.setText(player1Name);
                player2nameTV.setText(player2Name);
                player3nameTV.setText(player3Name);
                player1Score.setHint(player1Name + " " + getResources().getString(R.string.score));
                player2Score.setHint(player2Name + " " + getResources().getString(R.string.score));
                player3Score.setHint(player3Name + " " + getResources().getString(R.string.score));

                break;
            case 4:
                player1Name = getIntent().getExtras().getString("firstPlayerName");
                player2Name = getIntent().getExtras().getString("secondPlayerName");
                player3Name = getIntent().getExtras().getString("thirdPlayerName");
                player4Name = getIntent().getExtras().getString("fourthPlayerName");
                player1nameTV.setText(player1Name);
                player2nameTV.setText(player2Name);
                player3nameTV.setText(player3Name);
                player4nameTV.setText(player4Name);
                player1Score.setHint(player1Name + " " + getResources().getString(R.string.score));
                player2Score.setHint(player2Name + " " + getResources().getString(R.string.score));
                player3Score.setHint(player3Name + " " + getResources().getString(R.string.score));
                player4Score.setHint(player4Name + " " + getResources().getString(R.string.score));

                break;

        }


        // Total scores

        firstPlayer = (TextView) findViewById(R.id.firstPlayer);
        secondPlayer = (TextView) findViewById(R.id.secondPlayer);
        thirdPlayer = (TextView) findViewById(R.id.thirdPlayer);
        fourthPlayer = (TextView) findViewById(R.id.fourthPlayer);

        // lost checkbox
        player1Lost = (CheckBox) findViewById(R.id.player1lost);
        player2Lost = (CheckBox) findViewById(R.id.player2lost);
        player3Lost = (CheckBox) findViewById(R.id.player3lost);
        player4Lost = (CheckBox) findViewById(R.id.player4lost);

        // won checkbox

        player1Won = (CheckBox) findViewById(R.id.player1won);
        player2Won = (CheckBox) findViewById(R.id.player2won);
        player3Won = (CheckBox) findViewById(R.id.player3won);
        player4Won = (CheckBox) findViewById(R.id.player4won);


        // save score Button
        saveScore = (Button) findViewById(R.id.saveScores);


        // prepare Round 0 and update UI visibility
        rummyRounds = new RummyRound();
        List<HashMap<Integer, List<RummyPlayer>>> round0 = new ArrayList<>();
        List<RummyPlayer> rummyPlayers = new ArrayList<RummyPlayer>();
        switch (playersNumber) {

            case 2:
                rummyPlayers.add(new RummyPlayer(player1Name, 0));
                rummyPlayers.add(new RummyPlayer(player2Name, 0));
                // set total score to 0
                totalScores.put(player1Name, 0);
                totalScores.put(player2Name, 0);
                // set last round score to 0
                scoreOfLastRound.put(player1Name, 0);
                scoreOfLastRound.put(player2Name, 0);


                //scores
                player3Score.setVisibility(View.GONE);
                player4Score.setVisibility(View.GONE);
                //names
                player3nameTV.setVisibility(View.GONE);
                player4nameTV.setVisibility(View.GONE);
                //scoreboard
                thirdPlayer.setVisibility(View.GONE);
                fourthPlayer.setVisibility(View.GONE);
                //lost
                player3Lost.setVisibility(View.GONE);
                player4Lost.setVisibility(View.GONE);
                player3Lost.setVisibility(View.GONE);
                //won
                player3Won.setVisibility(View.GONE);
                player4Won.setVisibility(View.GONE);
                // places
                thirdPlaceTV.setVisibility(View.GONE);
                fourthPlaceTV.setVisibility(View.GONE);

                break;
            case 3:
                rummyPlayers.add(new RummyPlayer(player1Name, 0));
                rummyPlayers.add(new RummyPlayer(player2Name, 0));
                rummyPlayers.add(new RummyPlayer(player3Name, 0));
                // set total score to 0
                totalScores.put(player1Name, 0);
                totalScores.put(player2Name, 0);
                totalScores.put(player3Name, 0);
                // set last round score to 0
                scoreOfLastRound.put(player1Name, 0);
                scoreOfLastRound.put(player2Name, 0);
                scoreOfLastRound.put(player3Name, 0);

                //score
                player3Score.setVisibility(View.VISIBLE);
                player4Score.setVisibility(View.GONE);
                //names
                player3nameTV.setVisibility(View.VISIBLE);
                player4nameTV.setVisibility(View.GONE);
                //scorebaord
                thirdPlayer.setVisibility(View.VISIBLE);
                fourthPlayer.setVisibility(View.GONE);
                //lost
                player3Lost.setVisibility(View.VISIBLE);
                player4Lost.setVisibility(View.GONE);
                //won
                player3Won.setVisibility(View.VISIBLE);
                player4Won.setVisibility(View.GONE);
                // places
                thirdPlaceTV.setVisibility(View.VISIBLE);
                fourthPlaceTV.setVisibility(View.GONE);
                break;
            case 4:
                rummyPlayers.add(new RummyPlayer(player1Name, 0));
                rummyPlayers.add(new RummyPlayer(player2Name, 0));
                rummyPlayers.add(new RummyPlayer(player3Name, 0));
                rummyPlayers.add(new RummyPlayer(player4Name, 0));
                // set total score to 0
                totalScores.put(player1Name, 0);
                totalScores.put(player2Name, 0);
                totalScores.put(player3Name, 0);
                totalScores.put(player4Name, 0);
                // set last round score to 0
                scoreOfLastRound.put(player1Name, 0);
                scoreOfLastRound.put(player2Name, 0);
                scoreOfLastRound.put(player3Name, 0);
                scoreOfLastRound.put(player4Name, 0);

                //scores
                player3Score.setVisibility(View.VISIBLE);
                player4Score.setVisibility(View.VISIBLE);
                //names
                player3nameTV.setVisibility(View.VISIBLE);
                player4nameTV.setVisibility(View.VISIBLE);
                //scoreboard
                thirdPlayer.setVisibility(View.VISIBLE);
                fourthPlayer.setVisibility(View.VISIBLE);
                //lost
                player3Lost.setVisibility(View.VISIBLE);
                player4Lost.setVisibility(View.VISIBLE);
                //won
                player3Won.setVisibility(View.VISIBLE);
                player4Won.setVisibility(View.VISIBLE);
                // places
                thirdPlaceTV.setVisibility(View.VISIBLE);
                fourthPlaceTV.setVisibility(View.VISIBLE);

                break;

        }

        HashMap<Integer, List<RummyPlayer>> scoresOfRound0 = new HashMap<Integer, List<RummyPlayer>>();
        scoresOfRound0.put(0, rummyPlayers);
        rummyRounds.setRounds(scoresOfRound0);


        // autocomplete score when lost checkbox is checked

        player1Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player1Lost.isChecked()) {
                    player1Score.setText(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"));
                    player1Score.setEnabled(false);
                    player1Won.setChecked(false);
                } else

                    player1Score.setEnabled(true);

            }
        });

        player2Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player2Lost.isChecked()) {
                    player2Score.setText(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"));
                    player2Score.setEnabled(false);
                    player2Won.setChecked(false);
                } else

                    player2Score.setEnabled(true);

            }
        });

        player3Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player3Lost.isChecked()) {
                    player3Score.setText(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"));
                    player3Score.setEnabled(false);
                    player3Won.setChecked(false);
                } else

                    player3Score.setEnabled(true);

            }
        });

        player4Lost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player4Lost.isChecked()) {
                    player4Score.setText(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"));
                    player4Score.setEnabled(false);
                    player4Won.setChecked(false);
                } else

                    player4Score.setEnabled(true);

            }
        });

        // autocomplete score when won checkbox is checked

        player1Won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player1Won.isChecked()) {
                    player1Score.setText(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"));
                    player1Score.setEnabled(false);
                    player1Lost.setChecked(false);
                } else
                    player1Score.setEnabled(true);

            }
        });

        player2Won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player2Won.isChecked()) {
                    player2Score.setText(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"));
                    player2Score.setEnabled(false);
                    player2Lost.setChecked(false);
                } else
                    player2Score.setEnabled(true);

            }
        });

        player3Won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player3Won.isChecked()) {
                    player3Score.setText(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"));
                    player3Score.setEnabled(false);
                    player3Lost.setChecked(false);
                } else
                    player3Score.setEnabled(true);

            }
        });

        player4Won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (player4Won.isChecked()) {
                    player4Score.setText(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"));
                    player4Score.setEnabled(false);
                    player4Lost.setChecked(false);
                } else
                    player4Score.setEnabled(true);

            }
        });

        // save score Button
        saveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<RummyPlayer> rummyPlayers = new ArrayList<RummyPlayer>();
                // sorted scores
                List<Map.Entry<String, Integer>> scoresSorted;

                // save scores of N players
                switch (playersNumber) {

                    case 2:

                        // if input is empty , ask the user to insert it
                        if (player1Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player1Name, Toast.LENGTH_SHORT).show();

                        if (player2Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player2Name, Toast.LENGTH_SHORT).show();

                        // all the inputs are not emplty ==> do next step

                        if (player1Score.getText().toString().length() != 0 && player2Score.getText().toString().length() != 0) {

                            // check if there is cheat

                            // cheat1: all the players lost the game
                            if (Integer.parseInt(player1Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"))
                                    && Integer.parseInt(player2Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_all_the_players_lost), Toast.LENGTH_SHORT).show();

                                // cheat2: all the players won the game
                            else if (Integer.parseInt(player1Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player2Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_all_the_players_won), Toast.LENGTH_SHORT).show();

                                // cheat3: no player won the game
                            else if (Integer.parseInt(player1Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player2Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_no_player_won), Toast.LENGTH_SHORT).show();

                                // cheat4: more than one player won the game
                            else if (calculateNumberOfPlayersThatWon() > 1)
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_more_than_one_player_won), Toast.LENGTH_SHORT).show();

                                //everything seems ok , save the scores
                            else {
                                // add score
                                rummyPlayers.add(new RummyPlayer(player1Name, Integer.parseInt(player1Score.getText().toString())));
                                rummyPlayers.add(new RummyPlayer(player2Name, Integer.parseInt(player2Score.getText().toString())));
                                //total score
                                totalScores.put(player1Name, totalScores.get(player1Name) + Integer.parseInt(player1Score.getText().toString()));
                                totalScores.put(player2Name, totalScores.get(player2Name) + Integer.parseInt(player2Score.getText().toString()));
                                //save score of this round
                                scoreOfLastRound.put(player1Name, Integer.parseInt(player1Score.getText().toString()));
                                scoreOfLastRound.put(player2Name, Integer.parseInt(player2Score.getText().toString()));
                                //sort scores
                                scoresSorted = sortScores();
                                //update TextViews
                                firstPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                                secondPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());
                            }
                        }
                        break;
                    case 3:

                        // if input is empty , ask the user to insert it
                        if (player1Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player1Name, Toast.LENGTH_SHORT).show();

                        if (player2Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player2Name, Toast.LENGTH_SHORT).show();

                        if (player3Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player3Name, Toast.LENGTH_SHORT).show();


                        // all the inputs are not emplty ==> do next step

                        if (player1Score.getText().toString().length() != 0
                                && player2Score.getText().toString().length() != 0
                                && player3Score.getText().toString().length() != 0) {


                            // check if there is cheat

                            // cheat1: all the players lost the game
                            if (Integer.parseInt(player1Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"))
                                    && Integer.parseInt(player2Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"))
                                    && Integer.parseInt(player3Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_all_the_players_lost), Toast.LENGTH_SHORT).show();

                                // cheat2: all the players won the game
                            else if (Integer.parseInt(player1Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player2Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player3Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_all_the_players_won), Toast.LENGTH_SHORT).show();

                                // cheat3: no player won the game
                            else if (Integer.parseInt(player1Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player2Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player3Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_no_player_won), Toast.LENGTH_SHORT).show();

                                // cheat4: more than one player won the game
                            else if (calculateNumberOfPlayersThatWon() > 1)
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_more_than_one_player_won), Toast.LENGTH_SHORT).show();

                                //everything seems ok , save the scores
                            else {
                                rummyPlayers.add(new RummyPlayer(player1Name, Integer.parseInt(player1Score.getText().toString())));
                                rummyPlayers.add(new RummyPlayer(player2Name, Integer.parseInt(player2Score.getText().toString())));
                                rummyPlayers.add(new RummyPlayer(player3Name, Integer.parseInt(player3Score.getText().toString())));
                                //total score
                                totalScores.put(player1Name, totalScores.get(player1Name) + Integer.parseInt(player1Score.getText().toString()));
                                totalScores.put(player2Name, totalScores.get(player2Name) + Integer.parseInt(player2Score.getText().toString()));
                                totalScores.put(player3Name, totalScores.get(player3Name) + Integer.parseInt(player3Score.getText().toString()));
                                //save score of this round
                                scoreOfLastRound.put(player1Name, Integer.parseInt(player1Score.getText().toString()));
                                scoreOfLastRound.put(player2Name, Integer.parseInt(player2Score.getText().toString()));
                                scoreOfLastRound.put(player3Name, Integer.parseInt(player3Score.getText().toString()));
                                //sort scores
                                scoresSorted = sortScores();
                                //update TextViews
                                firstPlayer.setText(sortScores().get(2).getKey() + " " + scoresSorted.get(2).getValue());
                                secondPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                                thirdPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());
                            }
                        }
                        break;
                    case 4:

                        // if input is empty , ask the user to insert it
                        if (player1Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player1Name, Toast.LENGTH_SHORT).show();

                        if (player2Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player2Name, Toast.LENGTH_SHORT).show();

                        if (player3Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player3Name, Toast.LENGTH_SHORT).show();

                        if (player4Score.getText().toString().length() == 0)
                            Toast.makeText(getApplicationContext(), getResources().getString(R.string.please_put_player_score) + " " + player4Name, Toast.LENGTH_SHORT).show();


                        // all the inputs are not emplty ==> do next step

                        if (player1Score.getText().toString().length() != 0 && player2Score.getText().toString().length() != 0 && player3Score.getText().toString().length() != 0 && player4Score.getText().toString().length() != 0) {


                            // check if there is cheat

                            // cheat1: all the players lost the game
                            if (Integer.parseInt(player1Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"))
                                    && Integer.parseInt(player2Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"))
                                    && Integer.parseInt(player3Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100"))
                                    && Integer.parseInt(player4Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_LOSER_SCORE, "100")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_all_the_players_lost), Toast.LENGTH_SHORT).show();

                                // cheat2: all the players won the game
                            else if (Integer.parseInt(player1Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player2Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player3Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player4Score.getText().toString()) == Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_all_the_players_won), Toast.LENGTH_SHORT).show();

                                // cheat3: no player won the game
                            else if (Integer.parseInt(player1Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player2Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player3Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10"))
                                    && Integer.parseInt(player4Score.getText().toString()) != Integer.parseInt(sharedPref.getString(SettingsActivity.RUMMY_WINNER_SCORE, "-10")))
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_no_player_won), Toast.LENGTH_SHORT).show();

                                // cheat4: more than one player won the game
                            else if (calculateNumberOfPlayersThatWon() > 1)
                                Toast.makeText(getApplicationContext(), getResources().getString(R.string.cheat_more_than_one_player_won), Toast.LENGTH_SHORT).show();


                                //everything seems ok , save the scores
                            else {
                                rummyPlayers.add(new RummyPlayer(player1Name, Integer.parseInt(player1Score.getText().toString())));
                                rummyPlayers.add(new RummyPlayer(player2Name, Integer.parseInt(player2Score.getText().toString())));
                                rummyPlayers.add(new RummyPlayer(player3Name, Integer.parseInt(player3Score.getText().toString())));
                                rummyPlayers.add(new RummyPlayer(player4Name, Integer.parseInt(player4Score.getText().toString())));
                                //total score
                                totalScores.put(player1Name, totalScores.get(player1Name) + Integer.parseInt(player1Score.getText().toString()));
                                totalScores.put(player2Name, totalScores.get(player2Name) + Integer.parseInt(player2Score.getText().toString()));
                                totalScores.put(player3Name, totalScores.get(player3Name) + Integer.parseInt(player3Score.getText().toString()));
                                totalScores.put(player4Name, totalScores.get(player4Name) + Integer.parseInt(player4Score.getText().toString()));
                                //save score of this round
                                scoreOfLastRound.put(player1Name, Integer.parseInt(player1Score.getText().toString()));
                                scoreOfLastRound.put(player2Name, Integer.parseInt(player2Score.getText().toString()));
                                scoreOfLastRound.put(player3Name, Integer.parseInt(player3Score.getText().toString()));
                                scoreOfLastRound.put(player4Name, Integer.parseInt(player4Score.getText().toString()));
                                //sort scores
                                scoresSorted = sortScores();
                                //update TextViews
                                firstPlayer.setText(sortScores().get(3).getKey() + " " + scoresSorted.get(3).getValue());
                                secondPlayer.setText(sortScores().get(2).getKey() + " " + scoresSorted.get(2).getValue());
                                thirdPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                                fourthPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());
                            }
                        }
                        break;

                }


                rummyRounds.addRound(rummyPlayers);

                System.out.println("final socre is " + finalScore);

                // check if a player loose the game

                if (sortScores().get(0).getValue() >= finalScore) {
                    // first player loose
                    if (playersNumber == 3)
                        thirdPlayer.setTextColor(Color.RED);

                    else if (playersNumber == 4)
                        fourthPlayer.setTextColor(Color.RED);
                    setPlayerBloxInvisible(sortScores().get(0).getKey());
                }


                try {
                    // check 3rd player
                    if (sortScores().get(1).getValue() >= finalScore) {
                        // second player loose
                        if (playersNumber == 2)
                            secondPlayer.setTextColor(Color.RED);

                        else if (playersNumber == 3)
                            thirdPlayer.setTextColor(Color.RED);

                        setPlayerBloxInvisible(sortScores().get(1).getKey());

                    }
                } catch (IndexOutOfBoundsException e) {

                }


                // check 2nd player
                try {
                    if (sortScores().get(2).getValue() >= finalScore) {
                        // first player loose
                        secondPlayer.setTextColor(Color.RED);
                        setPlayerBloxInvisible(sortScores().get(2).getKey());

                    }

                } catch (Exception e) {

                }

                // check 1st player
                try {
                    if (sortScores().get(3).getValue() >= finalScore) {
                        // first player loose
                        firstPlayer.setTextColor(Color.RED);
                        setPlayerBloxInvisible(sortScores().get(3).getKey());

                    }

                } catch (Exception e) {

                }


                // check if the game ended (by checking the second player score)

                switch (playersNumber) {

                    case 2:
                        if (sortScores().get(0).getValue() >= finalScore) {
                            Intent gameEnded = new Intent(getApplicationContext(), RummyGameEnded.class);
                            gameEnded.putExtra("playersNumber", playersNumber);
                            gameEnded.putExtra("finalScore", finalScore);
                            gameEnded.putExtra("firstPlayerName", sortScores().get(1).getKey());
                            gameEnded.putExtra("firstPlayerScore", sortScores().get(1).getValue());
                            gameEnded.putExtra("secondPlayerName", sortScores().get(0).getKey());
                            gameEnded.putExtra("secondPlayerScore", sortScores().get(0).getValue());
                            startActivity(gameEnded);
                        }

                        break;
                    case 3:
                        if (sortScores().get(1).getValue() >= finalScore) {
                            Intent gameEnded = new Intent(getApplicationContext(), RummyGameEnded.class);
                            gameEnded.putExtra("playersNumber", playersNumber);
                            gameEnded.putExtra("finalScore", finalScore);
                            gameEnded.putExtra("firstPlayerName", sortScores().get(2).getKey());
                            gameEnded.putExtra("firstPlayerScore", sortScores().get(2).getValue());
                            gameEnded.putExtra("secondPlayerName", sortScores().get(1).getKey());
                            gameEnded.putExtra("secondPlayerScore", sortScores().get(1).getValue());
                            gameEnded.putExtra("thirdPlayerName", sortScores().get(0).getKey());
                            gameEnded.putExtra("thirdPlayerScore", sortScores().get(0).getValue());
                            startActivity(gameEnded);
                        }

                        break;
                    case 4:
                        if (sortScores().get(2).getValue() >= finalScore) {
                            Intent gameEnded = new Intent(getApplicationContext(), RummyGameEnded.class);
                            gameEnded.putExtra("playersNumber", playersNumber);
                            gameEnded.putExtra("finalScore", finalScore);
                            gameEnded.putExtra("firstPlayerName", sortScores().get(3).getKey());
                            gameEnded.putExtra("firstPlayerScore", sortScores().get(3).getValue());
                            gameEnded.putExtra("secondPlayerName", sortScores().get(2).getKey());
                            gameEnded.putExtra("secondPlayerScore", sortScores().get(2).getValue());
                            gameEnded.putExtra("thirdPlayerName", sortScores().get(1).getKey());
                            gameEnded.putExtra("thirdPlayerScore", sortScores().get(1).getValue());
                            gameEnded.putExtra("fourthPlayerName", sortScores().get(0).getKey());
                            gameEnded.putExtra("fourthPlayerScore", sortScores().get(0).getValue());
                            startActivity(gameEnded);
                        }

                        break;

                }


            }
        });

    }


    // sort scores
    private List<Map.Entry<String, Integer>> sortScores() {
        Set<Map.Entry<String, Integer>> set = totalScores.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
                set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }


    // hide loser zone

    private void setPlayerBloxInvisible(String loserName) {
        // player1 lost
        if (player1nameTV.getText().toString().equals(loserName)) {
            player1nameTV.setVisibility(View.GONE);
            player1Score.setText("0");
            player1Score.setVisibility(View.GONE);
            player1Lost.setVisibility(View.GONE);
            player1Won.setVisibility(View.GONE);
        }
        // player2 lost
        else if (player2nameTV.getText().toString().equals(loserName)) {
            player2nameTV.setVisibility(View.GONE);
            player2Score.setText("0");
            player2Score.setVisibility(View.GONE);
            player2Lost.setVisibility(View.GONE);
            player2Won.setVisibility(View.GONE);
        }
        // player3 lost
        else if (player3nameTV.getText().toString().equals(loserName)) {
            player3nameTV.setVisibility(View.GONE);
            player3Score.setText("0");
            player3Score.setVisibility(View.GONE);
            player3Lost.setVisibility(View.GONE);
            player3Won.setVisibility(View.GONE);
        }
        // player4 lost
        else {
            player4nameTV.setVisibility(View.GONE);
            player4Score.setText("0");
            player4Score.setVisibility(View.GONE);
            player4Lost.setVisibility(View.GONE);
            player4Won.setVisibility(View.GONE);
        }
    }


    private Integer calculateNumberOfPlayersThatWon() {

        Integer numberOfPlayersThatWon = 0;

        switch (playersNumber) {

            case 2:

                if (player1Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }
                if (player2Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }

                break;
            case 3:
                if (player1Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }
                if (player2Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }
                if (player3Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }

                break;
            case 4:
                if (player1Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }
                if (player2Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }
                if (player3Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }
                if (player4Won.isChecked()) {
                    numberOfPlayersThatWon++;
                }

                break;

        }

        return numberOfPlayersThatWon;
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(getResources().getString(R.string.quit_score_taking));
        alertDialog.setMessage(getResources().getString(R.string.are_you_sure_to_quit));
        alertDialog.setCancelable(true);

        alertDialog.setPositiveButton(
                getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                    }
                });
        alertDialog.setPositiveButton(
                getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //moveTaskToBack(true);
                        finish();
                    }
                });

        alertDialog.setNegativeButton(
                getResources().getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = alertDialog.create();
        alert11.show();
    }


    // option menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.rummy_score_taking_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.undo_save_score:
                undoLastSavedScore();
                break;
            case R.id.score_history:
                scoreHistory();
                break;
            case R.id.score_stats:
                startActivity(new Intent(getApplicationContext(), ScoreStats.class));
                break;
            case android.R.id.home:
                onBackPressed();

            default:
                break;
        }

        return true;
    }



    private void undoLastSavedScore() {

        List<Map.Entry<String, Integer>> scoresSorted;

        switch (playersNumber) {

            case 2:
                totalScores.put(player1Name, totalScores.get(player1Name) - scoreOfLastRound.get(player1Name));
                totalScores.put(player2Name, totalScores.get(player2Name) - scoreOfLastRound.get(player2Name));
                //sort scores
                scoresSorted = sortScores();
                //update TextViews
                firstPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                secondPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());


                break;
            case 3:
                totalScores.put(player1Name, totalScores.get(player1Name) - scoreOfLastRound.get(player1Name));
                totalScores.put(player2Name, totalScores.get(player2Name) - scoreOfLastRound.get(player2Name));
                totalScores.put(player3Name, totalScores.get(player3Name) - scoreOfLastRound.get(player3Name));
                //sort scores
                scoresSorted = sortScores();
                //update TextViews
                firstPlayer.setText(sortScores().get(2).getKey() + " " + scoresSorted.get(2).getValue());
                secondPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                thirdPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());

                break;
            case 4:
                totalScores.put(player1Name, totalScores.get(player1Name) - scoreOfLastRound.get(player1Name));
                totalScores.put(player2Name, totalScores.get(player2Name) - scoreOfLastRound.get(player2Name));
                totalScores.put(player3Name, totalScores.get(player3Name) - scoreOfLastRound.get(player3Name));
                totalScores.put(player4Name, totalScores.get(player4Name) - scoreOfLastRound.get(player4Name));
                //sort scores
                scoresSorted = sortScores();
                //update TextViews
                firstPlayer.setText(sortScores().get(3).getKey() + " " + scoresSorted.get(3).getValue());
                secondPlayer.setText(sortScores().get(2).getKey() + " " + scoresSorted.get(2).getValue());
                thirdPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                fourthPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());


                break;

        }


    }


    private void scoreHistory() {
        Dialog scoreHistoryDialog = new Dialog(RummyScoreTaking.this);
        scoreHistoryDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        scoreHistoryDialog.setContentView(R.layout.rummy_activity_rummy_score_history);
        scoreHistoryDialog.show();

        RecyclerView rv = (RecyclerView) scoreHistoryDialog.findViewById(R.id.recycler_view_scoreboard);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());
        RummyScoreHistoryAdapter rummyScoreHistoryAdapter = new RummyScoreHistoryAdapter(rummyRounds, playersNumber);
        rummyScoreHistoryAdapter.notifyDataSetChanged();
        rv.setAdapter(rummyScoreHistoryAdapter);


        rummyScoreHistoryAdapter.notifyDataSetChanged();

    }


}
