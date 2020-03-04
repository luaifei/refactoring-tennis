package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";

    public String getScore() {
        String score = "";
        if (P1point == P2point && P1point < 4) {
            score = getDisplayStrWithSameScoreAndLessThan4();
        }

        if (P1point == P2point && P1point >= 3) {
            score = "Deuce";
        }

        if (P1point == 0 || P2point == 0) {
            score = getDisplayStrWithOneScoreIsZero(score);
        }

        if (P1point < 4 || P2point < 4) {
            score = getDisplayStrWithScoreLessThan4(score);
        }

        if (P2point >= 3 && P1point >= 3) {
            score = getDisplayStrWithScoreGreaterOrEqualThan3(score);
        }

        if (P1point >= 4 || P2point >= 4) {
            score = getDisplayStrWithScoreGreaterOrEquals4(score);
        }

        return score;
    }

    private String getDisplayStrWithScoreGreaterOrEquals4(String score) {
        if ((P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if ((P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String getDisplayStrWithScoreGreaterOrEqualThan3(String score) {
        if (P1point > P2point) {
            score = "Advantage player1";
        }

        if (P2point > P1point) {
            score = "Advantage player2";
        }
        return score;
    }

    private String getDisplayStrWithScoreLessThan4(String score) {
        if (P1point > P2point) {
            if (P1point == 2) {
                P1res = "Thirty";
            }
            if (P1point == 3) {
                P1res = "Forty";
            }
            if (P2point == 1) {
                P2res = "Fifteen";
            }
            if (P2point == 2) {
                P2res = "Thirty";
            }
            score = P1res + "-" + P2res;
        }
        if (P2point > P1point) {
            if (P2point == 2) {
                P2res = "Thirty";
            }
            if (P2point == 3) {
                P2res = "Forty";
            }
            if (P1point == 1) {
                P1res = "Fifteen";
            }
            if (P1point == 2) {
                P1res = "Thirty";
            }
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String getDisplayStrWithOneScoreIsZero(String score) {
        if (P1point > 0) {
            if (P1point == 1) {
                P1res = "Fifteen";
            }
            if (P1point == 2) {
                P1res = "Thirty";
            }
            if (P1point == 3) {
                P1res = "Forty";
            }

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > 0) {
            if (P2point == 1) {
                P2res = "Fifteen";
            }
            if (P2point == 2) {
                P2res = "Thirty";
            }
            if (P2point == 3) {
                P2res = "Forty";
            }

            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String getDisplayStrWithSameScoreAndLessThan4() {
        if (P1point == 0) {
            return "Love-All";
        }
        if (P1point == 1) {
            return "Fifteen-All";
        }
        if (P1point == 2) {
            return "Thirty-All";
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