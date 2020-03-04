package cn.xpbootcamp.tennis.game4.displayrule;

import cn.xpbootcamp.tennis.game4.MyTennisGame;
import cn.xpbootcamp.tennis.game4.Player;

import java.util.Arrays;
import java.util.Comparator;

public abstract class BaseScoreDisplayRule implements ScoreDisplayRule {
    protected Player getLeadingPlayer(MyTennisGame game) {
        return Arrays.stream(game.getPlayers())
                .max(Comparator.comparing(Player::getScore))
                .get();
    }

    protected Player getLaggingPlayer(MyTennisGame game) {
        return Arrays.stream(game.getPlayers())
                .min(Comparator.comparing(Player::getScore))
                .get();
    }
}