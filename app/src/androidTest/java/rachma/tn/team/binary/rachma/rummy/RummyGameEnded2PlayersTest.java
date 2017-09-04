package rachma.tn.team.binary.rachma.rummy;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rachma.tn.team.binary.rachma.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by marwen on 14/08/17.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RummyGameEnded2PlayersTest {

    @Rule
    public ActivityTestRule<RummyGameEnded> mActivityRule =
            new ActivityTestRule<RummyGameEnded>(RummyGameEnded.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent intent = new Intent(targetContext, RummyGameEnded.class);
                    intent.putExtra("playersNumber", 2);
                    intent.putExtra("finalScore", 500);
                    intent.putExtra("firstPlayerName", "A");
                    intent.putExtra("secondPlayerName", "B");

                    intent.putExtra("firstPlayerScore", 5);
                    intent.putExtra("secondPlayerScore", 10);

                    return intent;
                }
            };

    @Test
    public void checkLeaderboard() {


        onView(ViewMatchers.withId(R.id.player1nameScoreboard)).check(matches(withText("A")));
        onView(ViewMatchers.withId(R.id.player1scoreScoreboard)).check(matches(withText("5")));

        onView(ViewMatchers.withId(R.id.player2nameScoreboard)).check(matches(withText("B")));
        onView(ViewMatchers.withId(R.id.player2scoreScoreboard)).check(matches(withText("10")));


    }
}

