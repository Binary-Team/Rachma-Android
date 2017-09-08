package rachma.tn.team.binary.rachma;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import rachma.tn.team.binary.rachma.entity.RummyPlayer;
import rachma.tn.team.binary.rachma.entity.RummyRound;

import static org.junit.Assert.assertEquals;

/**
 * Created by marwen on 9/8/17.
 */

public class RummyRoundsTest {

    RummyRound rummyRound = new RummyRound();

    RummyPlayer player1 = new RummyPlayer("Player1", 100);
    RummyPlayer player2 = new RummyPlayer("Player2", 100);
    RummyPlayer player3 = new RummyPlayer("Player3", 100);


    @Test
    public void addRound_isCorrect() throws Exception {
        List<RummyPlayer> rummyPlayerList = new ArrayList<>();
        rummyPlayerList.add(player1);
        rummyPlayerList.add(player2);
        rummyPlayerList.add(player3);

        rummyRound.addRound(rummyPlayerList);

        assertEquals(rummyRound.getRounds().get(0), rummyPlayerList);
    }

    @Test
    public void addScores_isCorrect() throws Exception {
        List<RummyPlayer> rummyPlayerList = new ArrayList<>();
        rummyPlayerList.add(player1);
        rummyPlayerList.add(player2);
        rummyPlayerList.add(player3);

        rummyRound.addRound(rummyPlayerList);


        assertEquals(rummyRound.getRounds().get(0), rummyPlayerList);

    }
}
