package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getDisplayStrWithSameScore();
        }

        if (m_score1 >= 4 || m_score2 >= 4) {
            return getDisplayStrWithScoreOver4();
        }

        return getDefaultDisplayStr();
    }

    private String getDefaultDisplayStr() {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;

        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = m_score1;
            } else {
                score.append("-");
                tempScore = m_score2;
            }
            score.append(getDescriptionForScore(tempScore));
        }
        return score.toString();
    }

    private String getDisplayStrWithScoreOver4() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            return "Advantage player1";
        }
        if (minusResult == -1) {
            return "Advantage player2";
        }
        if (minusResult >= 2) {
            return "Win for player1";
        }

        return "Win for player2";
    }

    private String getDisplayStrWithSameScore() {
        if (m_score1 >= 3) {
            return "Deuce";
        }

        return getDescriptionForScore(m_score1) + "-All";
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