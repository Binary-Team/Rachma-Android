package rachma.tn.team.binary.rachma.belote;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rachma.tn.team.binary.rachma.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by marwen on 14/08/17.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class BeloteGameSettingTest {

    @Rule
    public ActivityTestRule<BeloteSetting> mActivityRule =
            new ActivityTestRule(BeloteSetting.class);

    @Test
    public void checkRoundsNumber() {

        onView(ViewMatchers.withId(R.id.gamesNumber)).check(matches(withText("2")));

        onView(withId(R.id.decreaseGamesNumber)).perform(click());

        onView(ViewMatchers.withId(R.id.gamesNumber)).check(matches(withText("1")));

        onView(withId(R.id.decreaseGamesNumber)).perform(click());

        onView(ViewMatchers.withId(R.id.gamesNumber)).check(matches(withText("5")));

    }

    @Test
    public void checkPointsNumberDecrease() {

        onView(ViewMatchers.withId(R.id.pointpergame)).check(matches(withText("2000")));

        onView(withId(R.id.decreasePointsNumber)).perform(click());

        onView(ViewMatchers.withId(R.id.pointpergame)).check(matches(withText("1900")));

        for (int i = 0; i < 18; i++)
            onView(withId(R.id.decreasePointsNumber)).perform(click());


        onView(ViewMatchers.withId(R.id.pointpergame)).check(matches(withText("100")));

        onView(withId(R.id.decreasePointsNumber)).perform(click());
        onView(ViewMatchers.withId(R.id.pointpergame)).check(matches(withText("100")));


    }


}

