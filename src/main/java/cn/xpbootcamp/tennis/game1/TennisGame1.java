package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {
    private static String PLAYER1 = "player1";
    private static String PLAYER2 = "player2";

    private int score1 = 0;
    private int score2 = 0;

    public void wonPoint(String playerName) {

        if (PLAYER1.equals(playerName)) {
            score1 += 1;
        } else {
            score2 += 1;
        }
    }

    public String getScore() {
        if (score1 == score2) {
            return getDisplayStrWithSameScore();
        }

        if (score1 >= 4 || score2 >= 4) {
            return getDisplayStrWithScoreOver4();
        }

        return getDefaultDisplayStr();
    }

    private String getDefaultDisplayStr() {
        return getDescriptionForScore(score1) + "-" + getDescriptionForScore(score2);
    }

    private String getDisplayStrWithScoreOver4() {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            return "Advantage " + PLAYER1;
        }
        if (minusResult == -1) {
            return "Advantage " + PLAYER2;
        }
        if (minusResult >= 2) {
            return "Win for " + PLAYER1;
        }

        return "Win for " + PLAYER2;
    }

    private String getDisplayStrWithSameScore() {
        if (score1 >= 3) {
            return "Deuce";
        }

        return getDescriptionForScore(score1) + "-All";
    }

    private String getDescriptionForScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return null;
    }
}