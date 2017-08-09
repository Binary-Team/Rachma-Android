package rachma.tn.team.binary.rachma.belote;
//Author: Mohamed Amine Znaidi

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rachma.tn.team.binary.rachma.R;
import rachma.tn.team.binary.rachma.adapter.BeloteScoreboardAdapter;

public class BeloteScoreBoard extends AppCompatActivity {
    String team1Player1, team1Player2, team2Player1, team2Player2;
    Integer gamesNumber, pointsPerGame, ScoreTeam1 = 0, ScoreTeam2 = 0, GamesWonTeam1 = 0, GamesWonTeam2 = 0, ScoreTeam1Entred, ScoreTeam2Entred;
    List<String> scoreListTeam1 = new ArrayList<>();
    List<String> scoreListTeam2 = new ArrayList<>();
    private RecyclerView recyclerView1, recyclerView2;
    private BeloteScoreboardAdapter mAdapter1, mAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.belote_activity_belote_score_board);


        final TextView gamesWonTeam1 = (TextView) findViewById(R.id.gamesWonTeam1);
        final TextView gamesWonTeam2 = (TextView) findViewById(R.id.gamesWonTeam2);
        final EditText scoreTeam1 = (EditText) findViewById(R.id.scoreTeam1);
        final EditText scoreTeam2 = (EditText) findViewById(R.id.scoreTeam2);
        //get Player Names
        team1Player1 = getIntent().getExtras().getString("player1Team1");
        team1Player2 = getIntent().getExtras().getString("player2Team1");
        team2Player1 = getIntent().getExtras().getString("player1Team2");
        team2Player2 = getIntent().getExtras().getString("player2Team2");
        //Get Games Number
        gamesNumber = getIntent().getExtras().getInt("gamesNumber");
        // Get Points Per Game
        pointsPerGame = getIntent().getExtras().getInt("pointsPerGames");
        // Show Player Number
        TextView team1player1TV = (TextView) findViewById(R.id.team1player1);
        TextView team1player2TV = (TextView) findViewById(R.id.team1player2);
        TextView team2player1TV = (TextView) findViewById(R.id.team2player1);
        TextView team2player2TV = (TextView) findViewById(R.id.team2player2);
        team1player1TV.setText(team1Player1);
        team1player2TV.setText(team1Player2);
        team2player1TV.setText(team2Player1);
        team2player2TV.setText(team2Player2);
        final CheckBox beloteTeam1 = (CheckBox) findViewById(R.id.beloteTeam1);
        final CheckBox beloteTeam2 = (CheckBox) findViewById(R.id.beloteTeam2);



        // RecyclerView
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        mAdapter1 = new BeloteScoreboardAdapter(scoreListTeam1);
        recyclerView1.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mAdapter1);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter2 = new BeloteScoreboardAdapter(scoreListTeam2);
        recyclerView2.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager1);
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter2);


        //Text Change


        final Button addScore = (Button) findViewById(R.id.addscorebt);
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (scoreTeam1.getText().toString().length() == 0 && scoreTeam2.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Put at least one Team Score" +
                            "", Toast.LENGTH_SHORT).show();
                } else {
                    //Score Team 1 Configuration
                    if (scoreTeam1.getText().toString().length() > 0) {
                        ScoreTeam1Entred = Integer.decode(scoreTeam1.getText().toString());
                    } else {
                        if (Integer.decode(scoreTeam2.getText().toString()) > 162)
                            ScoreTeam1Entred = 0;
                        else
                            ScoreTeam1Entred = 162 - Integer.decode(scoreTeam2.getText().toString());
                    }

                    //Score Team2 Configuration
                    if (scoreTeam2.getText().toString().length() > 0) {
                        ScoreTeam2Entred = Integer.decode(scoreTeam2.getText().toString());
                    } else {
                        if (Integer.decode(scoreTeam1.getText().toString()) > 162)
                            ScoreTeam2Entred = 0;
                        else
                            ScoreTeam2Entred = 162 - Integer.decode(scoreTeam1.getText().toString());
                    }
                    Integer ScoreTeam1Rounded = 0, ScoreTeam2Rounded = 0;
                    if (ScoreTeam1Entred % 10 > 7) {
                        ScoreTeam1Rounded = ScoreTeam1Entred + 10 - ScoreTeam1Entred % 10;
                    } else if (ScoreTeam1Entred % 10 >= 5 && ScoreTeam1Entred % 10 <= 7) {
                        ScoreTeam1Rounded = ScoreTeam1Entred + 10 - ScoreTeam1Entred % 10;
                    } else {
                        ScoreTeam1Rounded = ScoreTeam1Entred - ScoreTeam1Entred % 10;
                    }
                    //Round Score Team2
                    if (ScoreTeam2Entred % 10 > 7) {
                        ScoreTeam2Rounded = ScoreTeam2Entred + 10 - ScoreTeam2Entred % 10;
                    } else if (ScoreTeam2Entred % 10 >= 5 && ScoreTeam2Entred % 10 <= 7) {
                        ScoreTeam2Rounded = ScoreTeam2Entred + 10 - ScoreTeam2Entred % 10;
                    } else {
                        ScoreTeam2Rounded = ScoreTeam2Entred - ScoreTeam2Entred % 10;
                    }
                    if (beloteTeam1.isChecked() && beloteTeam2.isChecked()) {
                        Toast.makeText(getApplicationContext(), "Only One Team Can Have Belote !", Toast.LENGTH_SHORT).show();
                        beloteTeam1.setChecked(false);
                        beloteTeam2.setChecked(false);
                        ScoreTeam1Rounded = 0;
                        ScoreTeam2Rounded = 0;

                    }

                    if (beloteTeam1.isChecked()) {
                        if (ScoreTeam1Entred == 0)
                            ScoreTeam2Rounded += 20;
                        else
                            ScoreTeam1Rounded += 20;
                    }

                    if (beloteTeam2.isChecked()) {
                        if (ScoreTeam2Entred == 0)
                            ScoreTeam1Rounded += 20;
                        else
                            ScoreTeam2Rounded += 20;
                    }


                    ScoreTeam1 = ScoreTeam1 + ScoreTeam1Rounded;
                    ScoreTeam2 = ScoreTeam2 + ScoreTeam2Rounded;
                    //end of  game for team 1
                    if (ScoreTeam1 >= pointsPerGame && ScoreTeam1 > ScoreTeam2) {
                        GamesWonTeam1++;
                        gamesWonTeam1.setText(GamesWonTeam1.toString());
                        ScoreTeam1 = 0;
                        ScoreTeam2 = 0;
                    }
                    //end of  game for team 2
                    if (ScoreTeam2 >= pointsPerGame && ScoreTeam2 > ScoreTeam1) {
                        GamesWonTeam2++;
                        gamesWonTeam2.setText(GamesWonTeam2.toString());
                        ScoreTeam1 = 0;
                        ScoreTeam2 = 0;
                    }

                    if (GamesWonTeam1 >= gamesNumber) {
                        Intent winner = new Intent(getApplicationContext(), Winner.class);
                        winner.putExtra("WinnerTeam", "Team1");
                        winner.putExtra("winner1", team1Player1);
                        winner.putExtra("winner2", team1Player2);
                        startActivity(winner);
                    }
                    if (GamesWonTeam2 >= gamesNumber) {
                        Intent winner = new Intent(getApplicationContext(), Winner.class);
                        winner.putExtra("WinnerTeam", "Team2");
                        winner.putExtra("Winner1", team2Player1);
                        winner.putExtra("Winner2", team2Player2);
                        startActivity(winner);
                    }


                    scoreListTeam1.add(ScoreTeam1.toString());
                    mAdapter1.notifyDataSetChanged();
                    scoreListTeam2.add(ScoreTeam2.toString());
                    mAdapter2.notifyDataSetChanged();
                    beloteTeam1.setChecked(false);
                    beloteTeam2.setChecked(false);
                    scoreTeam1.setText("");
                    scoreTeam2.setText("");


                }
            }
        });



    }
}
