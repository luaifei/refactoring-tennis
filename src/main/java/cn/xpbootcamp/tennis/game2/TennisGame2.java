package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";

    public String getScore() {
        String score = "";
        if (P1point == P2point) {
            if (P1point < 3) {
                return getDescriptionForScore(P1point) + "-All";
            }
            return "Deuce";
        }

        if (P1point > 0 && P1point <= 3) {
            P1res = getDescriptionForScore(P1point);
        }

        if (P1point > 0 && P2point == 0) {
            P2res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P2point > 0 && P2point <= 3) {
            P2res = getDescriptionForScore(P2point);
        }

        if (P2point > 0 && P1point == 0) {
            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point) {
            if (P1point < 4 && P1point >= 2) {
                P1res = getDescriptionForScore(P1point);
            }

            if (P2point > 0 && P2point <=2) {
                P2res = getDescriptionForScore(P2point);
            }
            score = P1res + "-" + P2res;
        }

        if (P2point > P1point) {
            if (P2point < 4 && P2point >= 2) {
                P2res = getDescriptionForScore(P2point);
            }

            if (P1point >= 1 && P1point <= 2) {
                P1res = getDescriptionForScore(P1point);
            }
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
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

    public void wonPoint(String player) {
        if ("player1".equals(player)) {
            P1point++;
        } else {
            P2point++;
        }
    }
}