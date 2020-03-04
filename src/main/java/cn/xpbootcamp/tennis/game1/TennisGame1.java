package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {
    private static String ADVANTAGE_FORMATTER = "Advantage %s";
    private static String WIN_FORMATTER = "Win for %s";

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return getDisplayWithSamePoint();
        }

        if (player1Score >= 4 || player2Score >= 4) {
            return getDisplayWithOnePlayerWon4MorePoints();
        }

        return getDefaultDisplay();
    }

    private String getDefaultDisplay() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score = String.format("%s-", score);
                tempScore = player2Score;
            }

            if (tempScore <= 3) {
                score += ScoreDesc.getDescStr(tempScore);
            }
        }
        return score;
    }

    private String getDisplayWithOnePlayerWon4MorePoints() {
        String score;
        int minusResult = player1Score - player2Score;

        if (minusResult == 1) {
            score = String.format(ADVANTAGE_FORMATTER, player1Name);
        } else if (minusResult == -1) {
            score = String.format(ADVANTAGE_FORMATTER, player2Name);
        } else {
            if (minusResult >= 2) {
                score = String.format(WIN_FORMATTER, player1Name);
            } else {
                score = String.format(WIN_FORMATTER, player2Name);
            }
        }

        return score;
    }

    private String getDisplayWithSamePoint() {
        if (player1Score <= 2) {
            return ScoreDesc.getDescStr(player1Score) + "-All";
        }

        return "Deuce";
    }

    enum ScoreDesc {
        Love, Fifteen, Thirty, Forty;

        public static String getDescStr(int score) {
            ScoreDesc[] values = ScoreDesc.values();
            return values[score].toString();
        }
    }
}