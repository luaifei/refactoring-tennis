package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {

        if (player1Point == player2Point) {
            return getDisplayWithSamePoint();
        }

        if (player1Point >= 3 && player2Point >= 3 && isGapEqual1Point()) {
            return "Advantage " + getLeadingPlayerName();
        }

        if (isAnyPlayerWon4MorePoint() && isGapGreaterOrEquals2()) {
            return "Win for " + getLeadingPlayerName();
        }

        return ScoreDesc.getDescStr(player1Point) + "-" + ScoreDesc.getDescStr(player2Point);
    }

    private boolean isAnyPlayerWon4MorePoint() {
        return player1Point >= 4 || player2Point >= 4;
    }

    private String getLeadingPlayerName() {
        return player1Point > player2Point ? player1Name : player2Name;
    }

    private boolean isGapGreaterOrEquals2() {
        return Math.abs(player1Point - player2Point) >= 2;
    }

    private boolean isGapEqual1Point() {
        return Math.abs(player1Point - player2Point) == 1;
    }

    private String getDisplayWithSamePoint() {
        if (player1Point <= 2) {
            return ScoreDesc.getDescStr(player1Point) + "-All";
        }

        return "Deuce";
    }

    public void P1Score() {
        player1Point++;
    }

    public void P2Score() {
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player1Name.equals(player)) {
            P1Score();
        } else {
            P2Score();
        }
    }

    enum ScoreDesc {
        Love, Fifteen, Thirty, Forty;

        public static String getDescStr(int score) {
            ScoreDesc[] values = ScoreDesc.values();
            return values[score].toString();
        }
    }
}