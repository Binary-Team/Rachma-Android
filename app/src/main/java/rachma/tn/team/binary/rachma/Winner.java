package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Winner extends AppCompatActivity {
    String WinnerTeam, Winner1, Winner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        WinnerTeam = getIntent().getExtras().getString("WinnerTeam");
        Winner1 = getIntent().getExtras().getString("Winner1");
        Winner2 = getIntent().getExtras().getString("Winner2");

        TextView winnerTeam = (TextView) findViewById(R.id.winnerteam);
        TextView cup = (TextView) findViewById(R.id.cup);
        TextView winner1 = (TextView) findViewById(R.id.winner1);
        TextView winner2 = (TextView) findViewById(R.id.winner2);

        winnerTeam.setText(WinnerTeam);
        cup.setText(WinnerTeam);
        winner1.setText(Winner1);
        winner2.setText(Winner2);



        Button home = (Button) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(getApplicationContext(), FirstMenu.class);
                startActivity(home);
            }
        });
    }
}
