package rachma.tn.team.binary.rachma.utils;

import java.util.List;
import java.util.Map;

/**
 * Created by marwen on 10/1/17.
 */

public class RoundCalculations {

    public Float calculateRoundProgress(List<Map.Entry<String, Integer>> scoresSorted, Integer finalScore) {

        Float roundProgress = new Float(0);

        switch (scoresSorted.size()) {
            case 2:
                roundProgress = ((float) scoresSorted.get(0).getValue() / finalScore) * 100;
                break;
            case 3:
                roundProgress = ((float) scoresSorted.get(1).getValue() / finalScore) * 100;
                break;
            case 4:
                roundProgress = ((float) scoresSorted.get(2).getValue() / finalScore) * 100;
                break;
        }

        return roundProgress;
    }

}
