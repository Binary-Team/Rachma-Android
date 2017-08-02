package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

//@Author Mohamed Amine Znaidi
public class BeloteSetting extends AppCompatActivity {

    TextView gamesNumberTV, pointsPerGameTV;
    Button done;
    ImageButton increaseGamesNumber, decreaseGamesNumber, increasePointsPerGame, decreasePointsPerGame;
    EditText player1Team1, player2Team1, player1Team2, player2Team2;
    Integer pointsPerGame = 2000, gamesNumber = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belote_setting);

        gamesNumberTV = (TextView) findViewById(R.id.gamesNumber);
        pointsPerGameTV = (TextView) findViewById(R.id.pointpergame);

        done = (Button) findViewById(R.id.doneBeloteSetting);

        player1Team1 = (EditText) findViewById(R.id.team1player1);
        player2Team1 = (EditText) findViewById(R.id.team1player2);
        player1Team2 = (EditText) findViewById(R.id.team2player1);
        player2Team2 = (EditText) findViewById(R.id.team2player2);

        increaseGamesNumber = (ImageButton) findViewById(R.id.increaseGamesNumber);
        decreaseGamesNumber = (ImageButton) findViewById(R.id.decreaseGamesNumber);

        increasePointsPerGame = (ImageButton) findViewById(R.id.increasePointsNumber);
        decreasePointsPerGame = (ImageButton) findViewById(R.id.decreasePointsNumber);

        increaseGamesNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gamesNumber >= 1 && gamesNumber < 5) {
                    gamesNumber++;
                } else {
                    gamesNumber = 1;
                }
                gamesNumberTV.setText(gamesNumber.toString());
            }
        });

        decreaseGamesNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gamesNumber > 1 && gamesNumber <= 5) {
                    gamesNumber--;
                } else {
                    gamesNumber = 5;
                }
                gamesNumberTV.setText(gamesNumber.toString());
            }
        });

        increasePointsPerGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsPerGame > 100 && pointsPerGame <= 5000) {
                    pointsPerGame += 100;
                }
                pointsPerGameTV.setText(pointsPerGame.toString());
            }
        });
        decreasePointsPerGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsPerGame >= 100 && pointsPerGame <= 5000) {
                    pointsPerGame -= 100;
                    pointsPerGameTV.setText(pointsPerGame.toString());
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beloteScoreBoard = new Intent(getApplication(), BeloteScoreBoard.class);
                beloteScoreBoard.putExtra("gamesNumber", gamesNumber);
                beloteScoreBoard.putExtra("pointsPerGames", pointsPerGame);
                beloteScoreBoard.putExtra("player1Team1", player1Team1.getText());
                beloteScoreBoard.putExtra("player2Team1", player2Team1.getText());
                beloteScoreBoard.putExtra("player1Team2", player1Team2.getText());
                beloteScoreBoard.putExtra("player1Team2", player2Team2.getText());
                startActivity(beloteScoreBoard);


            }
        });

    }
}
