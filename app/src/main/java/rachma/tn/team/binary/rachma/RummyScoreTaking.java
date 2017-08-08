package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import rachma.tn.team.binary.rachma.Entity.RummyPlayer;
import rachma.tn.team.binary.rachma.Entity.RummyRound;

public class RummyScoreTaking extends AppCompatActivity {

    static RummyRound rummyRounds;
    EditText player1Score, player2Score, player3Score, player4Score;
    TextView firstPlayer, secondPlayer, thirdPlayer, fourthPlayer;
    TextView player1nameTV, player2nameTV, player3nameTV, player4nameTV;
    Button saveScore;
    Integer playersNumber;
    String player1Name, player2Name, player3Name, player4Name;
    Integer finalScore;
    HashMap<String, Integer> totalScores = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rummy_score_taking);

        // get final score
        finalScore = getIntent().getExtras().getInt("finalScore");


        // get players number
        playersNumber = getIntent().getExtras().getInt("playersNumber");

        // players name
        player1nameTV = (TextView) findViewById(R.id.player1name);
        player2nameTV = (TextView) findViewById(R.id.player2name);
        player3nameTV = (TextView) findViewById(R.id.player3name);
        player4nameTV = (TextView) findViewById(R.id.player4name);

        // players score
        player1Score = (EditText) findViewById(R.id.player1Score);
        player2Score = (EditText) findViewById(R.id.player2Score);
        player3Score = (EditText) findViewById(R.id.player3Score);
        player4Score = (EditText) findViewById(R.id.player4Score);


        // get players names
        switch (playersNumber) {

            case 2:
                player1Name = getIntent().getExtras().getString("player1Name");
                player2Name = getIntent().getExtras().getString("player2Name");
                player1nameTV.setText(player1Name);
                player2nameTV.setText(player2Name);
                player1Score.setHint(player1Name + " " + player1Score.getHint());
                player2Score.setHint(player2Name + " " + player2Score.getHint());

                break;
            case 3:
                player1Name = getIntent().getExtras().getString("player1Name");
                player2Name = getIntent().getExtras().getString("player2Name");
                player3Name = getIntent().getExtras().getString("player3Name");
                player1nameTV.setText(player1Name);
                player2nameTV.setText(player2Name);
                player3nameTV.setText(player3Name);
                player1Score.setHint(player1Name + " " + player1Score.getHint());
                player2Score.setHint(player2Name + " " + player2Score.getHint());
                player3Score.setHint(player3Name + " " + player3Score.getHint());

                break;
            case 4:
                player1Name = getIntent().getExtras().getString("player1Name");
                player2Name = getIntent().getExtras().getString("player2Name");
                player3Name = getIntent().getExtras().getString("player3Name");
                player4Name = getIntent().getExtras().getString("player4Name");
                player1nameTV.setText(player1Name);
                player2nameTV.setText(player2Name);
                player3nameTV.setText(player3Name);
                player4nameTV.setText(player4Name);
                player1Score.setHint(player1Name + " " + player1Score.getHint());
                player2Score.setHint(player2Name + " " + player2Score.getHint());
                player3Score.setHint(player3Name + " " + player3Score.getHint());
                player4Score.setHint(player4Name + " " + player4Score.getHint());

                break;

        }


        // Total scores

        firstPlayer = (TextView) findViewById(R.id.firstPlayer);
        secondPlayer = (TextView) findViewById(R.id.secondPlayer);
        thirdPlayer = (TextView) findViewById(R.id.thirdPlayer);
        fourthPlayer = (TextView) findViewById(R.id.fourthPlayer);

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

                player3Score.setVisibility(View.GONE);
                player4Score.setVisibility(View.GONE);
                player3nameTV.setVisibility(View.GONE);
                player4nameTV.setVisibility(View.GONE);
                thirdPlayer.setVisibility(View.GONE);
                fourthPlayer.setVisibility(View.GONE);

                break;
            case 3:
                rummyPlayers.add(new RummyPlayer(player1Name, 0));
                rummyPlayers.add(new RummyPlayer(player2Name, 0));
                rummyPlayers.add(new RummyPlayer(player3Name, 0));
                // set total score to 0
                totalScores.put(player1Name, 0);
                totalScores.put(player2Name, 0);
                totalScores.put(player3Name, 0);

                player3Score.setVisibility(View.VISIBLE);
                player4Score.setVisibility(View.GONE);
                player3nameTV.setVisibility(View.VISIBLE);
                player4nameTV.setVisibility(View.GONE);
                thirdPlayer.setVisibility(View.VISIBLE);
                fourthPlayer.setVisibility(View.GONE);
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

                player3Score.setVisibility(View.VISIBLE);
                player4Score.setVisibility(View.VISIBLE);
                player3nameTV.setVisibility(View.VISIBLE);
                player4nameTV.setVisibility(View.VISIBLE);
                thirdPlayer.setVisibility(View.VISIBLE);
                fourthPlayer.setVisibility(View.VISIBLE);
                break;

        }

        HashMap<Integer, List<RummyPlayer>> scoresOfRound0 = new HashMap<Integer, List<RummyPlayer>>();
        scoresOfRound0.put(0, rummyPlayers);
        round0.add(scoresOfRound0);
        rummyRounds.setRounds(round0);


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
                        rummyPlayers.add(new RummyPlayer(player1Name, Integer.parseInt(player1Score.getText().toString())));
                        rummyPlayers.add(new RummyPlayer(player2Name, Integer.parseInt(player2Score.getText().toString())));
                        //total score
                        totalScores.put(player1Name, totalScores.get(player1Name) + Integer.parseInt(player1Score.getText().toString()));
                        totalScores.put(player2Name, totalScores.get(player2Name) + Integer.parseInt(player2Score.getText().toString()));
                        //sort scores
                        scoresSorted = sortScores();
                        //update TextViews
                        firstPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());
                        secondPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                        break;
                    case 3:
                        rummyPlayers.add(new RummyPlayer(player1Name, Integer.parseInt(player1Score.getText().toString())));
                        rummyPlayers.add(new RummyPlayer(player2Name, Integer.parseInt(player2Score.getText().toString())));
                        rummyPlayers.add(new RummyPlayer(player3Name, Integer.parseInt(player3Score.getText().toString())));
                        //total score
                        totalScores.put(player1Name, totalScores.get(player1Name) + Integer.parseInt(player1Score.getText().toString()));
                        totalScores.put(player2Name, totalScores.get(player2Name) + Integer.parseInt(player2Score.getText().toString()));
                        totalScores.put(player3Name, totalScores.get(player3Name) + Integer.parseInt(player3Score.getText().toString()));
                        //sort scores
                        scoresSorted = sortScores();
                        //update TextViews
                        firstPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());
                        secondPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                        thirdPlayer.setText(sortScores().get(2).getKey() + " " + scoresSorted.get(2).getValue());
                        break;
                    case 4:
                        rummyPlayers.add(new RummyPlayer(player1Name, Integer.parseInt(player1Score.getText().toString())));
                        rummyPlayers.add(new RummyPlayer(player2Name, Integer.parseInt(player2Score.getText().toString())));
                        rummyPlayers.add(new RummyPlayer(player3Name, Integer.parseInt(player3Score.getText().toString())));
                        rummyPlayers.add(new RummyPlayer(player4Name, Integer.parseInt(player4Score.getText().toString())));
                        //total score
                        totalScores.put(player1Name, totalScores.get(player1Name) + Integer.parseInt(player1Score.getText().toString()));
                        totalScores.put(player2Name, totalScores.get(player2Name) + Integer.parseInt(player2Score.getText().toString()));
                        totalScores.put(player3Name, totalScores.get(player3Name) + Integer.parseInt(player3Score.getText().toString()));
                        totalScores.put(player4Name, totalScores.get(player4Name) + Integer.parseInt(player4Score.getText().toString()));
                        //sort scores
                        scoresSorted = sortScores();
                        //update TextViews
                        firstPlayer.setText(sortScores().get(0).getKey() + " " + scoresSorted.get(0).getValue());
                        secondPlayer.setText(sortScores().get(1).getKey() + " " + scoresSorted.get(1).getValue());
                        thirdPlayer.setText(sortScores().get(2).getKey() + " " + scoresSorted.get(2).getValue());
                        fourthPlayer.setText(sortScores().get(3).getKey() + " " + scoresSorted.get(3).getValue());

                        break;

                }


                RummyRound previousRounds = rummyRounds;
                HashMap<Integer, List<RummyPlayer>> scoresOfThisRound = new HashMap<Integer, List<RummyPlayer>>();
                scoresOfThisRound.put(rummyRounds.getRounds().size(), rummyPlayers);

                previousRounds.getRounds().add(scoresOfThisRound);
                rummyRounds.setRounds(previousRounds.getRounds());


                System.out.println("final socre is " + finalScore);

                // check if a player loose the game

                if (sortScores().get(0).getValue() >= finalScore) {
                    // first player loose
                    firstPlayer.setTextColor(Color.RED);
                }

                // check 2nd player
                if (sortScores().get(1).getValue() >= finalScore) {
                    // second player loose
                    secondPlayer.setTextColor(Color.RED);
                }

                // check 3rd player
                try {
                    if (sortScores().get(2).getValue() >= finalScore) {
                        // first player loose
                        thirdPlayer.setTextColor(Color.RED);
                    }

                } catch (Exception e) {

                }

                // check 4th player
                try {
                    if (sortScores().get(3).getValue() >= finalScore) {
                        // first player loose
                        fourthPlayer.setTextColor(Color.RED);
                    }

                } catch (Exception e) {

                }


                // check if the game ended (by checking the second player score)

                switch (playersNumber) {

                    case 2:
                        if (sortScores().get(0).getValue() >= finalScore) {
                            Intent gameEnded = new Intent(getApplicationContext(), RummyGameEnded.class);
                            startActivity(gameEnded);
                        }

                        break;
                    case 3:
                        if (sortScores().get(1).getValue() >= finalScore) {
                            Intent gameEnded = new Intent(getApplicationContext(), RummyGameEnded.class);
                            startActivity(gameEnded);
                        }

                        break;
                    case 4:
                        if (sortScores().get(2).getValue() >= finalScore) {
                            Intent gameEnded = new Intent(getApplicationContext(), RummyGameEnded.class);
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


}
