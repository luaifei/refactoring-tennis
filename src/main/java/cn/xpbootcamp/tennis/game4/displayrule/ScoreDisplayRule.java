package cn.xpbootcamp.tennis.game4.displayrule;

import cn.xpbootcamp.tennis.game4.MyTennisGame;

import java.util.function.Predicate;

public interface ScoreDisplayRule extends Predicate<MyTennisGame> {
    String getDisplayStr(MyTennisGame game);
}
