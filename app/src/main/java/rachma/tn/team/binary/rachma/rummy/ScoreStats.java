package rachma.tn.team.binary.rachma.rummy;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

import rachma.tn.team.binary.rachma.R;

public class ScoreStats extends AppCompatActivity {

    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_stats);

        mChart = (LineChart) findViewById(R.id.score_history_chart);
        mChart.getDescription().setEnabled(false);

        setData();
    }


    private void setData() {

        Integer player1TotalScore = 0, player2TotalScore = 0, player3TotalScore = 0, player4TotalScore = 0;
        ArrayList<Entry> player1 = new ArrayList<Entry>();
        ArrayList<Entry> player2 = new ArrayList<Entry>();
        ArrayList<Entry> player3 = new ArrayList<Entry>();
        ArrayList<Entry> player4 = new ArrayList<Entry>();

        for (int i = 0; i < RummyScoreTaking.rummyRounds.getRounds().size(); i++) {

            player1TotalScore += RummyScoreTaking.rummyRounds.getRounds().get(i).get(0).getScore();
            player2TotalScore += RummyScoreTaking.rummyRounds.getRounds().get(i).get(1).getScore();

            player1.add(new Entry(i, player1TotalScore));
            player2.add(new Entry(i, player2TotalScore));

            if (RummyScoreTaking.playersNumber == 3) {
                player3TotalScore += RummyScoreTaking.rummyRounds.getRounds().get(i).get(2).getScore();
                player3.add(new Entry(i, player3TotalScore));
            } else if (RummyScoreTaking.playersNumber == 4) {
                player3TotalScore += RummyScoreTaking.rummyRounds.getRounds().get(i).get(2).getScore();
                player3.add(new Entry(i, player3TotalScore));
                player4TotalScore += RummyScoreTaking.rummyRounds.getRounds().get(i).get(3).getScore();
                player4.add(new Entry(i, player4TotalScore));
            }

        }

        LineDataSet player1lineDataSet;
        LineDataSet player2lineDataSet;
        LineDataSet player3lineDataSet = null;
        LineDataSet player4lineDataSet = null;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            //player1
            player1lineDataSet = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            player1lineDataSet.setValues(player1);
            //player2
            player2lineDataSet = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            player2lineDataSet.setValues(player2);

            if (RummyScoreTaking.playersNumber == 3) {
                //player3
                player3lineDataSet = (LineDataSet) mChart.getData().getDataSetByIndex(0);
                player3lineDataSet.setValues(player3);
            } else if (RummyScoreTaking.playersNumber == 4) {
                //player3
                player3lineDataSet = (LineDataSet) mChart.getData().getDataSetByIndex(0);
                player3lineDataSet.setValues(player3);
                //player4
                player4lineDataSet = (LineDataSet) mChart.getData().getDataSetByIndex(0);
                player4lineDataSet.setValues(player4);
            }

            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            //player1
            player1lineDataSet = new LineDataSet(player1, RummyScoreTaking.player1Name);
            player1lineDataSet.setColor(ContextCompat.getColor(getApplicationContext(), R.color.player1_chart_color));
            player1lineDataSet.setCircleColor(ContextCompat.getColor(getApplicationContext(), R.color.player1_chart_color));

            //player2
            player2lineDataSet = new LineDataSet(player2, RummyScoreTaking.player2Name);
            player2lineDataSet.setColor(ContextCompat.getColor(getApplicationContext(), R.color.player2_chart_color));
            player2lineDataSet.setCircleColor(ContextCompat.getColor(getApplicationContext(), R.color.player2_chart_color));


            if (RummyScoreTaking.playersNumber == 3) {
                //player3
                player3lineDataSet = new LineDataSet(player3, RummyScoreTaking.player3Name);
                player3lineDataSet.setColor(ContextCompat.getColor(getApplicationContext(), R.color.player3_chart_color));
                player3lineDataSet.setCircleColor(ContextCompat.getColor(getApplicationContext(), R.color.player3_chart_color));
            } else if (RummyScoreTaking.playersNumber == 4) {
                //player3
                player3lineDataSet = new LineDataSet(player3, RummyScoreTaking.player3Name);
                player3lineDataSet.setColor(ContextCompat.getColor(getApplicationContext(), R.color.player4_chart_color));
                player3lineDataSet.setCircleColor(ContextCompat.getColor(getApplicationContext(), R.color.player4_chart_color));
                //player4
                player4lineDataSet = new LineDataSet(player4, RummyScoreTaking.player4Name);
                player4lineDataSet.setColor(Color.GREEN);
                player4lineDataSet.setCircleColor(Color.GREEN);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(player1lineDataSet); // add the datasets
            dataSets.add(player2lineDataSet); // add the datasets

            if (RummyScoreTaking.playersNumber == 3) {
                dataSets.add(player3lineDataSet); // add the datasets
            } else if (RummyScoreTaking.playersNumber == 4) {
                dataSets.add(player3lineDataSet); // add the datasets
                dataSets.add(player4lineDataSet); // add the datasets
            }

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data
            mChart.setData(data);
        }
    }
}
