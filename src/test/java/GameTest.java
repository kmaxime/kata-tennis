import kata.tennis.model.Game;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void should_return_15_0_when_playerOne_scores()
    {
        //given
        Game aGame = new Game("playerOne", "playerTwo");

        //when
        aGame.scores("playerOne");

        //then
        assert(aGame.getScore().equals("15 - 0"));
    }

    @Test
    public void should_return_0_15_when_playerOne_scores()
    {
        //given
        Game aGame = new Game("playerOne", "playerTwo");

        //when
        aGame.scores("playerTwo");

        //then
        assert(aGame.getScore().equals("0 - 15"));
    }

    @Test
    public void should_be_deuce_when_40_40() {
        //given
        Game aGame = new Game("playerOne", "playerTwo");

        //when
        aGame.scores("playerOne");
        aGame.scores("playerOne");
        aGame.scores("playerOne");
        aGame.scores("playerTwo");
        aGame.scores("playerTwo");
        aGame.scores("playerTwo");
        aGame.scores("playerTwo");
        aGame.scores("playerOne");


        //then
        assert (aGame.isDeuce());
    }

    @Test
    public void should_win_when_scoring_when_40_and_not_deuce()
    {
        //given
        Game aGame = new Game("playerOne", "playerTwo");

        //when
        aGame.scores("playerOne");
        aGame.scores("playerOne");
        aGame.scores("playerOne");
        aGame.scores("playerOne");


        //then
        assert(aGame.isFinished());
    }

    @Test
    public void should_return_A_when_score_is_4_and_deuce() {
        //given
        Game aGame = new Game("playerOne", "playerTwo");

        //when
        aGame.scores("playerOne");
        aGame.scores("playerOne");
        aGame.scores("playerOne");
        aGame.scores("playerTwo");
        aGame.scores("playerTwo");
        aGame.scores("playerTwo");
        aGame.scores("playerOne");

        //then
        assert (aGame.getScore().equals("A - 40"));

    }
}
