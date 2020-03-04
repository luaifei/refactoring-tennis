package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int player1Point = 0;
    public int player2Point = 0;

    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (player1Point == player2Point) {
            return getDisplayWithSamePoint(score);
        }

        if (player1Point >= 3 && player2Point >= 3 && isGapEqual1Point()) {
            return "Advantage " + getLeadingPlayerName();
        }

        if (isAnyPlayerWon4MorePoint() && isGapGreaterOrEquals2()) {
            return "Win for " + getLeadingPlayerName();
        }
        return getDisplayWithScoreNoMoreThan3();
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

    private String getDisplayWithScoreNoMoreThan3() {
        String score;
        if (player1Point <= 3) {
            player1Result = ScoreDesc.getDescStr(player1Point);
        }
        if (player2Point <= 3) {
            player2Result = ScoreDesc.getDescStr(player2Point);
        }

        score = player1Result + "-" + player2Result;
        return score;
    }

    private String getDisplayWithSamePoint(String score) {
        if (player1Point <= 2) {
            score = ScoreDesc.getDescStr(player1Point) + "-All";
        }

        if (player1Point >= 3) {
            score = "Deuce";
        }
        return score;
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