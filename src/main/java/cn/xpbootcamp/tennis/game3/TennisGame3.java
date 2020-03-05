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
        String frontDisplayStr;
        if (player2Score < 4 && player1Score < 4 && !(player2Score + player1Score == 6)) {
            String[] displayStrArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            frontDisplayStr = displayStrArray[player2Score];
            return (player2Score == player1Score) ? frontDisplayStr + "-All" : frontDisplayStr + "-" + displayStrArray[player1Score];
        }
        if (player2Score == player1Score) {
            return "Deuce";
        }
        frontDisplayStr = player2Score > player1Score ? player1Name : player2Name;
        return ((player2Score - player1Score)*(player2Score - player1Score) == 1) ? "Advantage " + frontDisplayStr : "Win for " + frontDisplayStr;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            this.player2Score += 1;
        } else {
            this.player1Score += 1;
        }

    }

}