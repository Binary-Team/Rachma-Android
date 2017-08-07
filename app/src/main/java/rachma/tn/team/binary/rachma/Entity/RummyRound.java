package rachma.tn.team.binary.rachma.Entity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by marwen on 07/08/17.
 */

public class RummyRound {

    // round number and Players score
    List<HashMap<Integer, List<RummyPlayer>>> rounds;


    public List<HashMap<Integer, List<RummyPlayer>>> getRounds() {
        return rounds;
    }

    public void setRounds(List<HashMap<Integer, List<RummyPlayer>>> rounds) {
        this.rounds = rounds;
    }
}
