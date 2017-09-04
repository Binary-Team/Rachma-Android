package rachma.tn.team.binary.rachma.belote;

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
public class WinnerTest {

    @Rule
    public ActivityTestRule<Winner> mActivityRule =
            new ActivityTestRule<Winner>(Winner.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent intent = new Intent(targetContext, Winner.class);
                    intent.putExtra("Winner1", "A");
                    intent.putExtra("Winner2", "B");
                    intent.putExtra("WinnerTeam", "WinnerTeam");

                    return intent;
                }
            };

    @Test
    public void checkLeaderboard() {


        onView(ViewMatchers.withId(R.id.winnerteam)).check(matches(withText("WinnerTeam")));
        onView(ViewMatchers.withId(R.id.winner1)).check(matches(withText("A")));
        onView(ViewMatchers.withId(R.id.winner2)).check(matches(withText("B")));


    }
}

