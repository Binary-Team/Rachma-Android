package rachma.tn.team.binary.rachma;
//Author: Mohamed Amine Znaidi

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import rachma.tn.team.binary.rachma.Adapter.RummyScoreboardAdapter;

public class BeloteScoreBoard extends AppCompatActivity {
    String team1Player1, team1Player2, team2Player1, team2Player2;
    Integer gamesNumber, pointsPerGame;
    List<String> scoreListTeam1 = new ArrayList<>();
    List<String> scoreListTeam2 = new ArrayList<>();
    private RecyclerView recyclerView1, recyclerView2;
    private RummyScoreboardAdapter mAdapter1, mAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belote_score_board);

        //team1Player1 = getIntent().getExtras().getString("player1Team1");
        // team1Player2 = getIntent().getExtras().getString("palyer2Team1");
        //team2Player1 = getIntent().getExtras().getString("palyer2Team1");
        //team2Player2 = getIntent().getExtras().getString("palyer2Team2");
        // gamesNumber = getIntent().getExtras().getInt("gamesNumber");
        // pointsPerGame = getIntent().getExtras().getInt("pointsPerGames");
        //TextView team1player1TV = (TextView) findViewById(R.id.team1player1);
        //TextView team1player2TV = (TextView) findViewById(R.id.team1player2);
        //TextView team2player1TV = (TextView) findViewById(R.id.team2player1);
        //TextView team2player2TV = (TextView) findViewById(R.id.team2player2);
        //team1player1TV.setText(team1Player1);
        // team1player2TV.setText(team1Player2);
        //team2player1TV.setText(team2Player1);
        //team2player2TV.setText("team2Player2");


        // RecyclerView
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);
        mAdapter1 = new RummyScoreboardAdapter(scoreListTeam1);
        recyclerView1.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.setAdapter(mAdapter1);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter2 = new RummyScoreboardAdapter(scoreListTeam2);
        recyclerView2.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager1);
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(mAdapter2);

        Button addScore = (Button) findViewById(R.id.addscorebt);
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreListTeam1.add("score1");
                mAdapter1.notifyDataSetChanged();
                scoreListTeam2.add("score1");
                mAdapter2.notifyDataSetChanged();
            }
        });



    }
}
