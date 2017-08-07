package rachma.tn.team.binary.rachma;

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


//Author Marwen Doukh

public class RummyScoreboard extends AppCompatActivity {

    Integer playersNumber;

    List<String> scoreList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RummyScoreboardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rummy_scoreboard);

        // get players number
        playersNumber = getIntent().getExtras().getInt("playersNumber");

        // RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_scoreboard);
        mAdapter = new RummyScoreboardAdapter(scoreList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        // add score
        Button addScore = (Button) findViewById(R.id.addScore);
        addScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreList.add("score1");
                mAdapter.notifyDataSetChanged();
            }
        });


        /*
        for (int i =0; i<rummyRounds.getRounds().size();i++) {

                    System.out.println("round "+rummyRounds.getRounds().get(i));
                }

                */
    }
}











