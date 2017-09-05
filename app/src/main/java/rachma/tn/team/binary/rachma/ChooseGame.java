package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import rachma.tn.team.binary.rachma.belote.BeloteSetting;
import rachma.tn.team.binary.rachma.rummy.RummySetting;

//@Author Mohamed Amine Znaidi
public class ChooseGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);
        CardView rummyBt = (CardView) findViewById(R.id.rummy);
        CardView beloteBt = (CardView) findViewById(R.id.belote);

        rummyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rummysetting = new Intent(getApplication(), RummySetting.class);
                startActivity(rummysetting);
            }
        });

        beloteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent belotesetting = new Intent(getApplication(), BeloteSetting.class);
                startActivity(belotesetting);
            }
        });

    }
}
