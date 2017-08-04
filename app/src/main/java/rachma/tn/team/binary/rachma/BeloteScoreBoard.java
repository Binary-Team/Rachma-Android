package rachma.tn.team.binary.rachma;
//Author: Mohamed Amine Znaidi

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BeloteScoreBoard extends AppCompatActivity {
    String team1Player1, team1Player2, team2Player1, team2Player2;
    Integer gamesNumber, pointsPerGame;
    List<String> scoreListTeam1 = new ArrayList<>();
    List<String> scoreListTeam2 = new ArrayList<>();
    private RecyclerView recyclerView1, RecyclerViewer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belote_score_board);

        //team1Player1 = getIntent().getExtras().getString("player1Team1");
        team1Player2 = getIntent().getExtras().getString("palyer2Team1");
        team2Player1 = getIntent().getExtras().getString("palyer2Team1");
        team2Player2 = getIntent().getExtras().getString("palyer2Team2");
        gamesNumber = getIntent().getExtras().getInt("gamesNumber");
        pointsPerGame = getIntent().getExtras().getInt("pointsPerGames");
        TextView team1player1TV = (TextView) findViewById(R.id.team1player1);
        TextView team1player2TV = (TextView) findViewById(R.id.team1player2);
        TextView team2player1TV = (TextView) findViewById(R.id.team2player1);
        TextView team2player2TV = (TextView) findViewById(R.id.team2player2);
        team1player1TV.setText(team1Player1);
        team1player2TV.setText(team1Player2);
        team2player1TV.setText(team2Player1);
        team2player2TV.setText("team2Player2");





    }
}
