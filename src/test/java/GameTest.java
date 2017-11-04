import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.tennis.model.Game;
import kata.tennis.model.ScoreValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GameTest {

    private Game aGame;
    @Before
    public void initializeGame()
    {
        aGame = new Game("playerOne", "playerTwo");
    }

    @Test
    @Parameters ({"ZERO,ZERO,FIFTEEN,ZERO, playerOne",
            "FORTY,ADVANTAGE,FORTY,FORTY,playerOne",
            "ZERO,ZERO,ZERO,FIFTEEN,playerTwo",
            "ADVANTAGE,FORTY,FORTY,FORTY,playerTwo"})
    public void should_increment_score_when_scoring(ScoreValue inputPlayerOneScore,ScoreValue inputPlayerTwoScore, ScoreValue expectedPlayerOneScore, ScoreValue expectedPlayerTwoScore, String playerScoring)
    {
        //given
        aGame.setPlayerOneScore(inputPlayerOneScore);
        aGame.setPlayerTwoScore(inputPlayerTwoScore);

        //when
        aGame.scores(playerScoring);

        //then
        assertThat(aGame.getPlayerOneScore(), is(expectedPlayerOneScore));
        assertThat(aGame.getPlayerTwoScore(), is(expectedPlayerTwoScore));
    }

    @Test
    @Parameters ({"FORTY,FORTY,false,false",
                "ADVANTAGE,FORTY,true,false",
                "FORTY,THIRTY,true,false",
                "FORTY,ADVANTAGE,false,true",
                "FIFTEEN,FORTY,false,true"})
    public void should_be_winnable(ScoreValue inputPlayerOneScore,ScoreValue inputPlayerTwoScore, boolean expectedWinPlayerOne, boolean expectedWinPlayerTwo){
        //given
        aGame.setPlayerOneScore(inputPlayerOneScore);
        aGame.setPlayerTwoScore(inputPlayerTwoScore);

        //when
        boolean result1 = aGame.isWinnable("playerOne");
        boolean result2 = aGame.isWinnable("playerTwo");

        //then
        assertThat(result1, is(expectedWinPlayerOne));
        assertThat(result2, is(expectedWinPlayerTwo));
    }

    @Test
    public void should_player_finish(){
        //given
        String aPlayer = "player";

        //when
        aGame.finish(aPlayer);

        //then
        assertThat(aGame.getWinner(), is(aPlayer));

    }
}
