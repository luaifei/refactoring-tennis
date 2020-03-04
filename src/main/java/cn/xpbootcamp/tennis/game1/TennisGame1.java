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
        return String.format("%s-%s", ScoreDesc.getDescStr(player1Score),
                ScoreDesc.getDescStr(player2Score));
    }

    private String getDisplayWithOnePlayerWon4MorePoints() {
        int minusResult = player1Score - player2Score;
        String leadingPlayerName = minusResult > 0 ? player1Name : player2Name;

        int gapScore = Math.abs(minusResult);
        if (gapScore == 1) {
            return String.format(ADVANTAGE_FORMATTER, leadingPlayerName);
        }

        return String.format(WIN_FORMATTER, leadingPlayerName);
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