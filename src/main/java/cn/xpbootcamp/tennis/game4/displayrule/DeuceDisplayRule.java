package cn.xpbootcamp.tennis.game4.displayrule;

import cn.xpbootcamp.tennis.game4.MyTennisGame;

public class DeuceDisplayRule extends BaseScoreDisplayRule {
    @Override
    public String getDisplayStr(MyTennisGame game) {
        return "Deuce";
    }

    @Override
    public boolean test(MyTennisGame game) {
        return isSameScore(game) && isAllWon3PointsAtLeast(game);
    }

    private boolean isAllWon3PointsAtLeast(MyTennisGame game) {
        return getLaggingPlayer(game).getScore() >= 3 &&
                getLeadingPlayer(game).getScore() >= 3;
    }

    private boolean isSameScore(MyTennisGame game) {
        return getLaggingPlayer(game).getScore() == getLeadingPlayer(game).getScore();
    }
}
