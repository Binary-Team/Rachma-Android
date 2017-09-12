package rachma.tn.team.binary.rachma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rachma.tn.team.binary.rachma.belote.BeloteSetting;
import rachma.tn.team.binary.rachma.rummy.RummySetting;

//@Author Mohamed Amine Znaidi
public class ChooseGame extends Fragment {

    CardView rummyBt, beloteBt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_choose_game, null);
        rummyBt = (CardView) mView.findViewById(R.id.rummy);
        beloteBt = (CardView) mView.findViewById(R.id.belote);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rummyBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rummysetting = new Intent(getActivity(), RummySetting.class);
                startActivity(rummysetting);
            }
        });

        beloteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent belotesetting = new Intent(getActivity(), BeloteSetting.class);
                startActivity(belotesetting);
            }
        });

    }
}
