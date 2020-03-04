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


        score = getDisplayWithScoreNoMoreThan3();

        score = getDisplayWith3MoreScore(score);

        return getDisplayWith4MorePointAndGap2More(score);
    }

    private String getDisplayWith4MorePointAndGap2More(String score) {
        if (player1Point >= 4 && (player1Point - player2Point) >= 2) {
            score = "Win for " + player1Name;
        }
        if (player2Point >= 4 && (player2Point - player1Point) >= 2) {
            score = "Win for " + player2Name;
        }
        return score;
    }

    private String getDisplayWith3MoreScore(String score) {
        if (player1Point > player2Point && player2Point >= 3) {
            score = "Advantage " + player1Name;
        }

        if (player2Point > player1Point && player1Point >= 3) {
            score = "Advantage " +  player2Name;
        }
        return score;
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
        if (player1Point < 4) {
            if (player1Point == 0) {
                score = "Love";
            }
            if (player1Point == 1) {
                score = "Fifteen";
            }
            if (player1Point == 2) {
                score = "Thirty";
            }
            score += "-All";
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