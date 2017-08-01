package rachma.tn.team.binary.rachma.Adapter;

/**
 * Created by Marwen on 01/08/17.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import rachma.tn.team.binary.rachma.R;


public class RummyScoreboardAdapter extends RecyclerView.Adapter<RummyScoreboardAdapter.MyViewHolder> {


    private List<String> scoreList;

    public RummyScoreboardAdapter(List<String> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.scoreboard_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.score.setText(scoreList.get(position));

    }


    @Override
    public int getItemCount() {
        return scoreList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView score;

        public MyViewHolder(View view) {
            super(view);

            score = (TextView) view.findViewById(R.id.score);

        }
    }
}
