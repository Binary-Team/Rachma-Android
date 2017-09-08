package rachma.tn.team.binary.rachma.adapter;

/**
 * Created by Marwen on 01/08/17.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rachma.tn.team.binary.rachma.R;
import rachma.tn.team.binary.rachma.entity.RummyRound;


public class RummyScoreHistoryAdapter extends RecyclerView.Adapter<RummyScoreHistoryAdapter.MyViewHolder> {


    private RummyRound rummyRound;
    private Integer playersNumber;

    public RummyScoreHistoryAdapter(RummyRound rummyRound, Integer playersNumber) {
        this.rummyRound = rummyRound;
        this.playersNumber = playersNumber;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rummy_scores_history_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        switch (playersNumber) {

            case 2:
                holder.player1Score.setText(rummyRound.getRounds().get(position).get(0).getScore().toString());
                holder.player2Score.setText(rummyRound.getRounds().get(position).get(1).getScore().toString());
                holder.player1Name.setText(rummyRound.getRounds().get(position).get(0).getName());
                holder.player2Name.setText(rummyRound.getRounds().get(position).get(1).getName());
                break;
            case 3:
                holder.player1Score.setText(rummyRound.getRounds().get(position).get(0).getScore().toString());
                holder.player2Score.setText(rummyRound.getRounds().get(position).get(1).getScore().toString());
                holder.player3Score.setText(rummyRound.getRounds().get(position).get(2).getScore().toString());
                holder.player1Name.setText(rummyRound.getRounds().get(position).get(0).getName());
                holder.player2Name.setText(rummyRound.getRounds().get(position).get(1).getName());
                holder.player3Name.setText(rummyRound.getRounds().get(position).get(2).getName());
                break;
            case 4:
                holder.player1Score.setText(rummyRound.getRounds().get(position).get(0).getScore().toString());
                holder.player2Score.setText(rummyRound.getRounds().get(position).get(1).getScore().toString());
                holder.player3Score.setText(rummyRound.getRounds().get(position).get(2).getScore().toString());
                holder.player4Score.setText(rummyRound.getRounds().get(position).get(3).getScore().toString());
                holder.player1Name.setText(rummyRound.getRounds().get(position).get(0).getName());
                holder.player2Name.setText(rummyRound.getRounds().get(position).get(1).getName());
                holder.player3Name.setText(rummyRound.getRounds().get(position).get(2).getName());
                holder.player4Name.setText(rummyRound.getRounds().get(position).get(3).getName());
                break;

        }


    }


    @Override
    public int getItemCount() {
        return rummyRound.getRounds().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView player1Score, player2Score, player3Score, player4Score;
        TextView player1Name, player2Name, player3Name, player4Name;

        public MyViewHolder(View view) {
            super(view);

            switch (playersNumber) {

                case 2:
                    player1Score = (TextView) view.findViewById(R.id.player1ScoreScoreHistory);
                    player2Score = (TextView) view.findViewById(R.id.player2ScoreScoreHistory);
                    player1Name = (TextView) view.findViewById(R.id.player1NameScoreHistory);
                    player2Name = (TextView) view.findViewById(R.id.player2NameScoreHistory);
                    break;
                case 3:
                    player1Score = (TextView) view.findViewById(R.id.player1ScoreScoreHistory);
                    player2Score = (TextView) view.findViewById(R.id.player2ScoreScoreHistory);
                    player3Score = (TextView) view.findViewById(R.id.player3ScoreScoreHistory);
                    player3Score.setVisibility(View.VISIBLE);
                    player1Name = (TextView) view.findViewById(R.id.player1NameScoreHistory);
                    player2Name = (TextView) view.findViewById(R.id.player2NameScoreHistory);
                    player3Name = (TextView) view.findViewById(R.id.player3NameScoreHistory);
                    player3Name.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    player1Score = (TextView) view.findViewById(R.id.player1ScoreScoreHistory);
                    player2Score = (TextView) view.findViewById(R.id.player2ScoreScoreHistory);
                    player3Score = (TextView) view.findViewById(R.id.player3ScoreScoreHistory);
                    player3Score.setVisibility(View.VISIBLE);
                    player4Score = (TextView) view.findViewById(R.id.player4ScoreScoreHistory);
                    player4Score.setVisibility(View.VISIBLE);
                    player1Name = (TextView) view.findViewById(R.id.player1NameScoreHistory);
                    player2Name = (TextView) view.findViewById(R.id.player2NameScoreHistory);
                    player3Name = (TextView) view.findViewById(R.id.player3NameScoreHistory);
                    player3Name.setVisibility(View.VISIBLE);
                    player4Name = (TextView) view.findViewById(R.id.player4NameScoreHistory);
                    player4Name.setVisibility(View.VISIBLE);
                    break;

            }


        }
    }
}
