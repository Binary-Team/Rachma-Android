package rachma.tn.team.binary.rachma;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import rachma.tn.team.binary.rachma.utils.LocalStorage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by marwen on 28/08/17.
 */


@RunWith(AndroidJUnit4.class)
public class LocalStorageTest {


    @Test
    public void savePlayerName_CorrectPlayerName_ReturnsTrue() {
        String playerName = "player1";

        LocalStorage localStorage = LocalStorage.getInstance(InstrumentationRegistry.getTargetContext());

        localStorage.savePlayerName(playerName);
        String result = localStorage.findPlayerName(playerName);


        assertThat(result, is(playerName));

    }


    @Test
    public void savePlayerName_Duplicate_PlayerName_ReturnsFalse() {
        String playerName = "player1";

        LocalStorage localStorage = LocalStorage.getInstance(InstrumentationRegistry.getTargetContext());

        Boolean saved = localStorage.savePlayerName(playerName);


        assertThat(saved, is(false));

    }

    @Test
    public void playerNameAlreadyExists_PlayerName_ReturnsTrue() {

        String playerName = "player1";

        LocalStorage localStorage = LocalStorage.getInstance(InstrumentationRegistry.getTargetContext());

        Boolean exists = localStorage.playerNameAlreadyExists(playerName);


        assertThat(exists, is(true));

    }
}
