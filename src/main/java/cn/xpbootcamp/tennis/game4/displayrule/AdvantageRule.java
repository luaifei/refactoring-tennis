package cn.xpbootcamp.tennis.game4.displayrule;

import cn.xpbootcamp.tennis.game4.MyTennisGame;

public class AdvantageRule extends BaseScoreDisplayRule {
    @Override
    public String getDisplayStr(MyTennisGame game) {
        return "Advantage " + getLeadingPlayer(game).getName();
    }

    @Override
    public boolean test(MyTennisGame game) {
        return getLeadingPlayer(game).getScore() >= 3
                && getLaggingPlayer(game).getScore() >= 3
                && getLeadingPlayer(game).getScore() - getLaggingPlayer(game).getScore() == 1;
    }
}
