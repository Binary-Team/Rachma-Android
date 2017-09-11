package rachma.tn.team.binary.rachma.rummy;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rachma.tn.team.binary.rachma.MainActivity;

/**
 * Created by marwen on 14/08/17.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RummyGameSettingTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void checkUIVisibility() {


       /* onView(ViewMatchers.withId(R.id.playersNumber)).check(matches(withText("2")));

        onView(withId(R.id.player1Name)).check(matches(isDisplayed()));

        onView(withId(R.id.player2Name)).check(matches(isDisplayed()));


        // decrease players number

        onView(withId(R.id.decreasePlayersNumber)).perform(click());

        onView(withId(R.id.player1Name)).check(matches(isDisplayed()));

        onView(withId(R.id.player2Name)).check(matches(isDisplayed()));

        onView(withId(R.id.player3Name)).check(matches(not(isDisplayed())));

        onView(withId(R.id.player4Name)).check(matches(not(isDisplayed())));*/


    }
}

