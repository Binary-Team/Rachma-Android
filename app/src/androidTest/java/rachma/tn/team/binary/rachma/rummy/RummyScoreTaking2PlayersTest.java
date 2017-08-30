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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by marwen on 14/08/17.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RummyScoreTaking2PlayersTest {

    @Rule
    public ActivityTestRule<RummyScoreTaking> mActivityRule =
            new ActivityTestRule<RummyScoreTaking>(RummyScoreTaking.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent intent = new Intent(targetContext, RummyScoreTaking.class);
                    intent.putExtra("playersNumber", 2);
                    intent.putExtra("finalScore", 500);
                    intent.putExtra("firstPlayerName", "A");
                    intent.putExtra("secondPlayerName", "B");
                    return intent;
                }
            };


    @Test
    public void checkInitialGameSetup() {

        onView(ViewMatchers.withId(R.id.player1nameScoreTaking)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.player2nameScoreTaking)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.player3nameScoreTaking)).check(matches(not(isDisplayed())));
        onView(ViewMatchers.withId(R.id.player4nameScoreTaking)).check(matches(not(isDisplayed())));


        onView(ViewMatchers.withId(R.id.firstPlace)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.secondPlace)).check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.thirdPlace)).check(matches(not(isDisplayed())));
        onView(ViewMatchers.withId(R.id.fourthPlayer)).check(matches(not(isDisplayed())));

    }


    @Test
    public void testCheats() {
        // Testing Cheats proof


        // cheat : all the players lost
        onView(withId(R.id.player1lost)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player1lost)).check(matches(isChecked()));
        onView(withId(R.id.player2lost)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player2lost)).check(matches(isChecked()));


        onView(withId(R.id.saveScores)).perform(scrollTo(), click());


        onView(withText(R.string.cheat_all_the_players_lost))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));


        // cheat : all the players won

        onView(withId(R.id.player1won)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player1won)).check(matches(isChecked()));
        onView(withId(R.id.player2won)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player2won)).check(matches(isChecked()));


        onView(withId(R.id.saveScores)).perform(scrollTo(), click());


        onView(withText(R.string.cheat_all_the_players_won))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));


        // cheat : no player won

        onView(withId(R.id.player1lost)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player1lost)).check(matches(isChecked()));

        onView(withId(R.id.player2won)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player2won)).check(matches(isNotChecked()));


        onView(withId(R.id.player2ScoreScoreTaking)).perform(scrollTo(), typeText(String.valueOf(20)), closeSoftKeyboard());

        onView(withId(R.id.saveScores)).perform(scrollTo(), click());


        onView(withText(R.string.cheat_no_player_won))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));


    }


    @Test
    public void testAddScore() {

        // set scores
        onView(withId(R.id.player1won)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player1won)).check(matches(isChecked()));
        onView(ViewMatchers.withId(R.id.player1lost)).check(matches(not(isChecked())));

        onView(withId(R.id.player2lost)).perform(scrollTo(), click());
        onView(ViewMatchers.withId(R.id.player2lost)).check(matches(isChecked()));
        onView(ViewMatchers.withId(R.id.player2won)).check(matches(not(isChecked())));


        onView(withId(R.id.saveScores)).perform(scrollTo(), click());


        // check leaderboard
        onView(ViewMatchers.withId(R.id.firstPlayer)).check(matches(withText("A -10")));
        onView(ViewMatchers.withId(R.id.secondPlayer)).check(matches(withText("B 100")));


    }

}

