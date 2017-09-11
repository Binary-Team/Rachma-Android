package rachma.tn.team.binary.rachma.rummy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import rachma.tn.team.binary.rachma.R;
import rachma.tn.team.binary.rachma.utils.LocalStorage;

//Author Marwen Doukh

public class RummySetting extends Fragment {

    Integer playersNumber = 2;
    Integer finalScore = 500;
    TextView playersNumberTV, finalScoreTV;
    ImageButton increasePlayersNumber, decreasePlayersNumber, increaseFinalScore, decreaseFinalScore;
    Button done;
    AutoCompleteTextView player1Name, player2Name, player3Name, player4Name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.rummy_activity_rummy_setting, null);
        // players names
        player1Name = (AutoCompleteTextView) mView.findViewById(R.id.player1Name);
        player2Name = (AutoCompleteTextView) mView.findViewById(R.id.player2Name);
        player3Name = (AutoCompleteTextView) mView.findViewById(R.id.player3Name);
        player4Name = (AutoCompleteTextView) mView.findViewById(R.id.player4Name);

        done = (Button) mView.findViewById(R.id.doneRummySetting);

        // Increase/Decrease players number
        playersNumberTV = (TextView) mView.findViewById(R.id.playersNumber);
        increasePlayersNumber = (ImageButton) mView.findViewById(R.id.increasePlayersNumber);
        decreasePlayersNumber = (ImageButton) mView.findViewById(R.id.decreasePlayersNumber);
        // final score

        finalScoreTV = (TextView) mView.findViewById(R.id.finalScore);
        increaseFinalScore = (ImageButton) mView.findViewById(R.id.increaseFinalScore);
        decreaseFinalScore = (ImageButton) mView.findViewById(R.id.decreaseFinalScore);

        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





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


        // autocomplete player names
        player1Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player1Name.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player1Name.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        player2Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player2Name.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player2Name.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        player3Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player3Name.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player3Name.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        player4Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player4Name.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player4Name.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        // move to Rummy scoreboard
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LocalStorage localStorage = LocalStorage.getInstance(getActivity());

                Intent rummyScoreTaking = new Intent(getActivity(), RummyScoreTaking.class);
                rummyScoreTaking.putExtra("playersNumber", playersNumber);
                rummyScoreTaking.putExtra("finalScore", finalScore);

                switch (playersNumber) {

                    case 2:
                        // if player name is empty set it to default

                        //player1
                        if (player1Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("firstPlayerName", getResources().getString(R.string.player) + "1");
                        else {
                            rummyScoreTaking.putExtra("firstPlayerName", player1Name.getText().toString());
                            localStorage.savePlayerName(player1Name.getText().toString());
                        }
                        //player2
                        if (player2Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("secondPlayerName", getResources().getString(R.string.player) + "2");
                        else {
                            rummyScoreTaking.putExtra("secondPlayerName", player2Name.getText().toString());
                            localStorage.savePlayerName(player2Name.getText().toString());
                        }
                        break;
                    case 3:
                        // if player name is empty set it to default

                        //player1
                        if (player1Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("firstPlayerName", getResources().getString(R.string.player) + "1");
                        else {
                            rummyScoreTaking.putExtra("firstPlayerName", player1Name.getText().toString());
                            localStorage.savePlayerName(player1Name.getText().toString());
                        }
                        //player2
                        if (player2Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("secondPlayerName", getResources().getString(R.string.player) + "2");
                        else {
                            rummyScoreTaking.putExtra("secondPlayerName", player2Name.getText().toString());
                            localStorage.savePlayerName(player2Name.getText().toString());
                        }

                        //player3
                        if (player3Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("thirdPlayerName", getResources().getString(R.string.player) + "3");
                        else {
                            rummyScoreTaking.putExtra("thirdPlayerName", player3Name.getText().toString());
                            localStorage.savePlayerName(player3Name.getText().toString());
                        }


                        break;
                    case 4:
                        // if player name is empty set it to default

                        //player1
                        if (player1Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("firstPlayerName", getResources().getString(R.string.player) + "1");
                        else {
                            rummyScoreTaking.putExtra("firstPlayerName", player1Name.getText().toString());
                            localStorage.savePlayerName(player1Name.getText().toString());
                        }
                        //player2
                        if (player2Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("secondPlayerName", getResources().getString(R.string.player) + "2");
                        else {
                            rummyScoreTaking.putExtra("secondPlayerName", player2Name.getText().toString());
                            localStorage.savePlayerName(player2Name.getText().toString());
                        }

                        //player3
                        if (player3Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("thirdPlayerName", getResources().getString(R.string.player) + "3");
                        else {
                            rummyScoreTaking.putExtra("thirdPlayerName", player3Name.getText().toString());
                            localStorage.savePlayerName(player3Name.getText().toString());
                        }

                        //player4
                        if (player4Name.getText().toString().length() == 0)
                            rummyScoreTaking.putExtra("fourthPlayerName", getResources().getString(R.string.player) + "4");
                        else {
                            rummyScoreTaking.putExtra("fourthPlayerName", player4Name.getText().toString());
                            localStorage.savePlayerName(player4Name.getText().toString());
                        }


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