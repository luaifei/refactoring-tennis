package cn.xpbootcamp.tennis.game4.displayrule;

import cn.xpbootcamp.tennis.game4.MyTennisGame;
import cn.xpbootcamp.tennis.game4.Player;

import java.util.Arrays;

public class WonDisplayRule extends BaseScoreDisplayRule {

    @Override
    public String getDisplayStr(MyTennisGame game) {
        return "Win for " + getLeadingPlayer(game).getName();
    }

    @Override
    public boolean test(MyTennisGame game) {
        Player leadingPlayer = getLeadingPlayer(game);
        Player laggingPlayer = getLaggingPlayer(game);

        return leadingPlayer.getScore() >= 4
                && isLeadingBy2PointsAtLeast(leadingPlayer, laggingPlayer);
    }

    private boolean isLeadingBy2PointsAtLeast(Player leadingPlayer, Player laggingPlayer) {
        return leadingPlayer.getScore() - laggingPlayer.getScore() >= 2;
    }
}