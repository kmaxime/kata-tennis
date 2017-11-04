import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.tennis.model.ScoreValue;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ScoreValueTest {

    @Test
    @Parameters({"ZERO,FIFTEEN",
            "FIFTEEN,THIRTY",
            "THIRTY,FORTY",
            "FORTY,ADVANTAGE",
            "ADVANTAGE,ADVANTAGE"})
    public void should_increment_score_when_next(ScoreValue input, ScoreValue expected) {
        //given
        ScoreValue playerScore = input;

        //when
        ScoreValue result = playerScore.next();

        //then
        assertThat(result, is(expected));
    }

    @Test
    @Parameters({"ZERO,ZERO",
            "FIFTEEN,ZERO",
            "THIRTY,FIFTEEN",
            "FORTY,THIRTY",
            "ADVANTAGE,FORTY"})
    public void should_decrement_score_when_previous(ScoreValue input, ScoreValue expected) {
        //given
        ScoreValue playerScore = input;

        //when
        ScoreValue result = playerScore.previous();

        //then
        assertThat(result, is(expected));
    }
}