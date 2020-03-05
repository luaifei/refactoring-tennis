package cn.xpbootcamp.tennis.game3;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame3 implements TennisGame {

    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (isEveryPlayerWonLessThan4Point() && !isBothPlayerWon3Point()) {
            return getDisplayStrWithAllWonLessThan4ButNotBothWon3Point();
        }

        if (player2Score == player1Score) {
            return "Deuce";
        }

        String leadingPlayerName = player2Score > player1Score ? player1Name : player2Name;
        return isGapEquals1() ? "Advantage " + leadingPlayerName : "Win for " + leadingPlayerName;
    }

    private String getDisplayStrWithAllWonLessThan4ButNotBothWon3Point() {
        String frontDisplayStr = getDisplayStr(player2Score);
        return (player2Score == player1Score) ?
                frontDisplayStr + "-All" :
                frontDisplayStr + "-" + getDisplayStr(player1Score);
    }

    private boolean isGapEquals1() {
        return Math.abs(player2Score - player1Score) == 1;
    }

    private boolean isBothPlayerWon3Point() {
        return player2Score == 3 && player1Score == 3;
    }

    private boolean isEveryPlayerWonLessThan4Point() {
        return player2Score < 4 && player1Score < 4;
    }

    private String getDisplayStr(int score) {
        String[] displayStrArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return displayStrArray[score];
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            this.player2Score += 1;
        } else {
            this.player1Score += 1;
        }

    }

}