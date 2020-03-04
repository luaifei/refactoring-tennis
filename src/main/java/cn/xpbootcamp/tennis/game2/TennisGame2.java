package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String getScore() {
        if (P1point == P2point) {
            return getDisplayStrWithSameScore();
        }

        String playerNameWithHighScore = P1point > P2point ? "player1" : "player2";

        if (isAnyScoreGreaterOrEqual4() && isGapGreaterThan2AtLeast()) {
            return getWinDisplayStr(playerNameWithHighScore);
        }

        if (isAllGreaterOrEqual3()) {
            return getAdvantageDisplayStr(playerNameWithHighScore);
        }

        return getDefaultDisplayStr();
    }

    private String getAdvantageDisplayStr(String playerNameWithHighScore) {
        return "Advantage " + playerNameWithHighScore;
    }

    private String getWinDisplayStr(String playerNameWithHighScore) {
        return "Win for " + playerNameWithHighScore;
    }

    private String getDefaultDisplayStr() {
        return getDescriptionForScore(P1point) + "-" + getDescriptionForScore(P2point);
    }

    private boolean isAllGreaterOrEqual3() {
        return P1point >= 3 && P2point >= 3;
    }

    private boolean isGapGreaterThan2AtLeast() {
        return Math.abs(P1point - P2point) >= 2;
    }

    private boolean isAnyScoreGreaterOrEqual4() {
        return P1point >= 4 || P2point >= 4;
    }

    private String getDisplayStrWithSameScore() {
        if (P1point < 3) {
            return getDescriptionForScore(P1point) + "-All";
        }
        return "Deuce";
    }

    private String getDescriptionForScore(int score) {
        String[] displayStrArray = new String[] {"Love", "Fifteen", "Thirty", "Forty"};
        return displayStrArray[score];
    }

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            P1point++;
        } else {
            P2point++;
        }
    }
}