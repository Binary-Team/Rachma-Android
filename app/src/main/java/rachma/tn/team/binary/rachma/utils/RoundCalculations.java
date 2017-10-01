package rachma.tn.team.binary.rachma.utils;

import java.util.List;

/**
 * Created by marwen on 10/1/17.
 */

public class RoundCalculations {

    private Float calculateRoundProgress(List<Integer> scores, Integer finalScore) {

        Float roundProgress = new Float(0);

        switch (scores.size()) {
            case 2:
                roundProgress = finalScore / scores.get(0).floatValue();
                break;
            case 3:
                roundProgress = finalScore / scores.get(1).floatValue();
                break;
            case 4:
                roundProgress = finalScore / scores.get(2).floatValue();
                break;
        }

        return roundProgress;
    }

}
