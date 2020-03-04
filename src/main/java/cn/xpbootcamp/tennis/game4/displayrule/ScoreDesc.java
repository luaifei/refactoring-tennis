package cn.xpbootcamp.tennis.game4.displayrule;

public enum ScoreDesc {
    Love, Fifteen, Thirty, Forty;

    public static String getDescStr(int score) {
        ScoreDesc[] values = ScoreDesc.values();
        return values[score].toString();
    }
}
