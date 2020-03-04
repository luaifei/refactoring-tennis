package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

    private int score2;
    private int score1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String displayStr;
        if (isAllLessThan4() && !isSameScoreWith3()) {
            String[] displayStrArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            displayStr = displayStrArray[score1];
            return (score1 == score2) ? displayStr + "-All" : displayStr + "-" + displayStrArray[score2];
        }

        if (score1 == score2) {
            return "Deuce";
        }

        displayStr = score1 > score2 ? player1Name : player2Name;
        return isGapLessThan2() ? "Advantage " + displayStr : "Win for " + displayStr;
    }

    private boolean isGapLessThan2() {
        return (score1 - score2)*(score1 - score2) == 1;
    }

    private boolean isSameScoreWith3() {
        return score1 == 3 && score2 == 3;
    }

    private boolean isAllLessThan4() {
        return score1 < 4 && score2 < 4;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            this.score1 += 1;
        } else {
            this.score2 += 1;
        }
    }

}