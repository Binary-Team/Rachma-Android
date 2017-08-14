package rachma.tn.team.binary.rachma.rummy;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rachma.tn.team.binary.rachma.MainActivity;
import rachma.tn.team.binary.rachma.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by marwen on 14/08/17.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RummyGameSettingTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(RummySetting.class);

    @Test
    public void checkUIVisibility() {


        onView(ViewMatchers.withId(R.id.playersNumber)).check(matches(withText("2")));

        onView(withId(R.id.player1Name)).check(matches(isDisplayed()));

        onView(withId(R.id.player2Name)).check(matches(isDisplayed()));


        // decrease players number

        onView(withId(R.id.decreasePlayersNumber)).perform(click());

        onView(withId(R.id.player1Name)).check(matches(isDisplayed()));

        onView(withId(R.id.player2Name)).check(matches(isDisplayed()));

        onView(withId(R.id.player3Name)).check(matches(not(isDisplayed())));

        onView(withId(R.id.player4Name)).check(matches(not(isDisplayed())));


    }
}

