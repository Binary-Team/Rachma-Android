package rachma.tn.team.binary.rachma.rummy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rachma.tn.team.binary.rachma.R;
import rachma.tn.team.binary.rachma.adapter.BeloteScoreboardAdapter;


//Author Marwen Doukh

public class RummyScoreHistory extends AppCompatActivity {

    Integer playersNumber;

    List<String> scoreList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BeloteScoreboardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rummy_activity_rummy_scoreboard);

        // get players number
        playersNumber = getIntent().getExtras().getInt("playersNumber");

        // RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_scoreboard);
        mAdapter = new BeloteScoreboardAdapter(scoreList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




    }
}











