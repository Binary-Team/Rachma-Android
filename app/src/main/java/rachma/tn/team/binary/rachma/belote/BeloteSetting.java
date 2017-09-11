package rachma.tn.team.binary.rachma.belote;

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

//@Author Mohamed Amine Znaidi
public class BeloteSetting extends Fragment {

    TextView gamesNumberTV, pointsPerGameTV;
    Button done;
    ImageButton increaseGamesNumber, decreaseGamesNumber, increasePointsPerGame, decreasePointsPerGame;
    AutoCompleteTextView player1Team1, player2Team1, player1Team2, player2Team2;
    Integer pointsPerGame = 2000, gamesNumber = 2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.belote_activity_belote_setting, null);
        gamesNumberTV = (TextView) mView.findViewById(R.id.gamesNumber);
        pointsPerGameTV = (TextView) mView.findViewById(R.id.pointpergame);
        done = (Button) mView.findViewById(R.id.doneBeloteSetting);

        player1Team1 = (AutoCompleteTextView) mView.findViewById(R.id.team1player1);
        player2Team1 = (AutoCompleteTextView) mView.findViewById(R.id.team1player2);
        player1Team2 = (AutoCompleteTextView) mView.findViewById(R.id.team2player1);
        player2Team2 = (AutoCompleteTextView) mView.findViewById(R.id.team2player2);

        increaseGamesNumber = (ImageButton) mView.findViewById(R.id.increaseGamesNumber);
        decreaseGamesNumber = (ImageButton) mView.findViewById(R.id.decreaseGamesNumber);

        increasePointsPerGame = (ImageButton) mView.findViewById(R.id.increasePointsNumber);
        decreasePointsPerGame = (ImageButton) mView.findViewById(R.id.decreasePointsNumber);

        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        increaseGamesNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gamesNumber >= 1 && gamesNumber < 5) {
                    gamesNumber++;
                } else {
                    gamesNumber = 1;
                }
                gamesNumberTV.setText(gamesNumber.toString());
            }
        });

        decreaseGamesNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gamesNumber > 1 && gamesNumber <= 5) {
                    gamesNumber--;
                } else {
                    gamesNumber = 5;
                }
                gamesNumberTV.setText(gamesNumber.toString());
            }
        });

        increasePointsPerGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsPerGame > 100 && pointsPerGame <= 5000) {
                    pointsPerGame += 100;
                }
                pointsPerGameTV.setText(pointsPerGame.toString());
            }
        });
        decreasePointsPerGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pointsPerGame > 100 && pointsPerGame <= 5000) {
                    pointsPerGame -= 100;
                    pointsPerGameTV.setText(pointsPerGame.toString());
                }
            }
        });


        // autocomplete player names

        player1Team1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player1Team1.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player1Team1.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        player2Team1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player2Team1.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player2Team1.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        player1Team2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player1Team2.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player1Team2.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        player2Team2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LocalStorage localStorage = LocalStorage.getInstance(getActivity());
                String[] names = localStorage.findPlayerName(player2Team2.getText().toString());
                // Create the adapter and set it to the AutoCompleteTextView
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.player_names_suggestion, R.id.playerNameSuggestion, names);
                player2Team2.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LocalStorage localStorage = LocalStorage.getInstance(getActivity());

                Intent beloteScoreBoard = new Intent(getActivity(), BeloteScoreBoard.class);
                beloteScoreBoard.putExtra("gamesNumber", gamesNumber);
                beloteScoreBoard.putExtra("pointsPerGames", pointsPerGame);
                if (player1Team1.getText().length() == 0) {
                    beloteScoreBoard.putExtra("player1Team1", getResources().getString(R.string.player) + "1");
                } else {
                    beloteScoreBoard.putExtra("player1Team1", player1Team1.getText().toString());
                    localStorage.savePlayerName(player1Team1.getText().toString());

                }
                //player 2 Team 1 Name
                if (player2Team1.getText().length() == 0) {
                    beloteScoreBoard.putExtra("player2Team1", getResources().getString(R.string.player) + "2");
                } else {
                    beloteScoreBoard.putExtra("player2Team1", player2Team1.getText().toString());
                    localStorage.savePlayerName(player2Team1.getText().toString());

                }

                //player 1 Team 2 Name
                if (player1Team2.getText().length() == 0) {
                    beloteScoreBoard.putExtra("player1Team2", getResources().getString(R.string.player) + "1");
                } else {
                    beloteScoreBoard.putExtra("player1Team2", player1Team2.getText().toString());
                    localStorage.savePlayerName(player1Team2.getText().toString());

                }
                //player 2 Team 2 Name
                if (player2Team2.getText().length() == 0) {
                    beloteScoreBoard.putExtra("player2Team2", getResources().getString(R.string.player) + "2");
                } else {
                    beloteScoreBoard.putExtra("player2Team2", player2Team2.getText().toString());
                    localStorage.savePlayerName(player2Team2.getText().toString());

                }

                startActivity(beloteScoreBoard);


            }
        });

    }
}
