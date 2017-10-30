package kata.tennis.model;

import com.sun.tracing.dtrace.FunctionName;

import java.awt.*;

public class Game {

    private int _playerOneScore = 0;
    private int _playerTwoScore = 0;
    private String _playerOneName = null;
    private String _playerTwoName = null;

    public Game(String playerOne, String playerTwo) {
        _playerOneName = playerOne;
        _playerTwoName = playerTwo;
    }

    public void scores(String playerName) {
        if (playerName.equals(_playerOneName))
        {
            if(_playerTwoScore == 4)
            {
                _playerTwoScore--;
            }
            else if(_playerOneScore == 3)
            {
                _playerOneScore = 5;
            }
            else {
                _playerOneScore++;
            }
        }
        else if (playerName.equals(_playerTwoName))
        {
            if(_playerOneScore == 4)
            {
                _playerOneScore--;
            }
            else if(_playerTwoScoreScore == 3)
            {
                _playerTwoScore = 5;
            }
            else
            {
                _playerTwoScore++;
            }
        }
    }

    public String getScore(String playerName) {
        if (playerName.equals(_playerOneName))
        {
            return toScore(_playerOneScore);
        }
        else
        {
            return toScore(_playerTwoScore);
        }
    }

    public String toScore (int playerScore) {
        switch (playerScore) {
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            case 4:
                return "A";

        }
        return "winner";
    }

    public String getScore() {

        return toScore(_playerOneScore)+" - "+toScore(_playerTwoScore);
    }

    public boolean isDeuce() {
        boolean cond_1 = _playerOneScore == _playerTwoScore;
        boolean cond_2 = _playerOneScore == 3;
        return cond_1 && cond_2;
    }

    public boolean isFinished() {
        boolean cond_1 = _playerOneScore == 5;
        boolean cond_2 = _playerTwoScore == 5;
        return cond_1 || cond_2;
    }







}
