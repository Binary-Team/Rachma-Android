package rachma.tn.team.binary.rachma.rummy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import rachma.tn.team.binary.rachma.R;

//Author Marwen Doukh

public class RummySetting extends AppCompatActivity {

    Integer playersNumber = 2;
    Integer finalScore = 500;
    TextView playersNumberTV, finalScoreTV;
    ImageButton increasePlayersNumber, decreasePlayersNumber, increaseFinalScore, decreaseFinalScore;
    Button done;
    EditText player1Name, player2Name, player3Name, player4Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rummy_activity_rummy_setting);

        // players names
        player1Name = (EditText) findViewById(R.id.player1Name);
        player2Name = (EditText) findViewById(R.id.player2Name);
        player3Name = (EditText) findViewById(R.id.player3Name);
        player4Name = (EditText) findViewById(R.id.player4Name);


        done = (Button) findViewById(R.id.done);



        // Increase/Decrease players number
        playersNumberTV = (TextView) findViewById(R.id.playersNumber);
        increasePlayersNumber = (ImageButton) findViewById(R.id.increasePlayersNumber);
        decreasePlayersNumber = (ImageButton) findViewById(R.id.decreasePlayersNumber);

        increasePlayersNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playersNumber < 4)
                    playersNumber++;
                playersNumberTV.setText(playersNumber.toString());
                updateTextViewsVisibility();

            }
        });

        decreasePlayersNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (playersNumber > 2)
                    playersNumber--;
                playersNumberTV.setText(playersNumber.toString());
                updateTextViewsVisibility();

            }
        });


        // final score

        finalScoreTV = (TextView) findViewById(R.id.finalScore);
        increaseFinalScore = (ImageButton) findViewById(R.id.increaseFinalScore);
        decreaseFinalScore = (ImageButton) findViewById(R.id.decreaseFinalScore);

        increaseFinalScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalScore += 50;
                finalScoreTV.setText(finalScore.toString());

            }
        });

        decreaseFinalScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (finalScore > 100)
                    finalScore -= 50;
                finalScoreTV.setText(finalScore.toString());
            }
        });



        // move to Rummy scoreboard
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent rummyScoreTaking = new Intent(getApplicationContext(), RummyScoreTaking.class);
                rummyScoreTaking.putExtra("playersNumber", playersNumber);
                rummyScoreTaking.putExtra("finalScore", finalScore);

                switch (playersNumber) {

                    case 2:
                        rummyScoreTaking.putExtra("firstPlayerName", player1Name.getText().toString());
                        rummyScoreTaking.putExtra("secondPlayerName", player2Name.getText().toString());
                        break;
                    case 3:
                        rummyScoreTaking.putExtra("firstPlayerName", player1Name.getText().toString());
                        rummyScoreTaking.putExtra("secondPlayerName", player2Name.getText().toString());
                        rummyScoreTaking.putExtra("thirdPlayerName", player3Name.getText().toString());
                        break;
                    case 4:
                        rummyScoreTaking.putExtra("firstPlayerName", player1Name.getText().toString());
                        rummyScoreTaking.putExtra("secondPlayerName", player2Name.getText().toString());
                        rummyScoreTaking.putExtra("thirdPlayerName", player3Name.getText().toString());
                        rummyScoreTaking.putExtra("fourthPlayerName", player4Name.getText().toString());
                        break;

                }

                startActivity(rummyScoreTaking);

            }

        });



    }


    // update TextViews visibility according to players number chosen
    void updateTextViewsVisibility() {
        switch (playersNumber) {
            case 2:
                player1Name.setVisibility(View.VISIBLE);
                player2Name.setVisibility(View.VISIBLE);
                player3Name.setVisibility(View.GONE);
                player4Name.setVisibility(View.GONE);
                break;
            case 3:
                player1Name.setVisibility(View.VISIBLE);
                player2Name.setVisibility(View.VISIBLE);
                player3Name.setVisibility(View.VISIBLE);
                player4Name.setVisibility(View.GONE);
                break;
            case 4:
                player1Name.setVisibility(View.VISIBLE);
                player2Name.setVisibility(View.VISIBLE);
                player3Name.setVisibility(View.VISIBLE);
                player4Name.setVisibility(View.VISIBLE);
                break;
        }
    }
}