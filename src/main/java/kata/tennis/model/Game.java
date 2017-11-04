package kata.tennis.model;

public class Game {

    private ScoreValue playerOneScore;
    private ScoreValue playerTwoScore;
    private String playerOneName;
    private String playerTwoName;
    private String winner;

    public Game(String playerOne, String playerTwo) {
        playerOneName = playerOne;
        playerTwoName = playerTwo;
        playerOneScore = ScoreValue.ZERO;
        playerTwoScore = ScoreValue.ZERO;
    }

    public void scores(String playerName) {
        if (playerName.equals(playerOneName)) {
            if (isWinnable(playerOneName)) {
                finish(playerOneName);
            } else if (playerTwoScore.equals(ScoreValue.ADVANTAGE)) {
                this.playerTwoScore = playerTwoScore.previous();
            } else {
                this.playerOneScore = playerOneScore.next();
            }
        } else if (playerName.equals(playerTwoName)) {
            if (isWinnable(playerTwoName)) {
                finish(playerTwoName);
            } else if (playerOneScore.equals(ScoreValue.ADVANTAGE)) {
                this.playerOneScore = playerOneScore.previous();
            } else {
                this.playerTwoScore = playerTwoScore.next();
            }
        }
    }

    public boolean isWinnable(String playerName) {
        if (playerName.equals(playerOneName)) {
            if (((playerOneScore.equals(ScoreValue.FORTY) && (!playerTwoScore.equals(ScoreValue.ADVANTAGE)) && !playerTwoScore.equals(ScoreValue.FORTY))) ||
                    (playerOneScore.equals(ScoreValue.ADVANTAGE))) {
                return true;
            } else {
                return false;
            }
        } else if (playerName.equals(playerTwoName)) {
            if (((playerTwoScore.equals(ScoreValue.FORTY) && (!playerOneScore.equals(ScoreValue.ADVANTAGE)) && !playerOneScore.equals(ScoreValue.FORTY))) ||
                    (playerTwoScore.equals(ScoreValue.ADVANTAGE))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void finish(String playerName) {
        winner = playerName;
    }

    public void setPlayerOneScore(ScoreValue playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public void setPlayerTwoScore(ScoreValue playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public ScoreValue getPlayerOneScore() {
        return playerOneScore;
    }

    public ScoreValue getPlayerTwoScore() {
        return playerTwoScore;
    }

    public String getWinner() {
        return winner;
    }
}
