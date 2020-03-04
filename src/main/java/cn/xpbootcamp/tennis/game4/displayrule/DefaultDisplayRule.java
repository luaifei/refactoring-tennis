package cn.xpbootcamp.tennis.game4.displayrule;

import cn.xpbootcamp.tennis.game4.MyTennisGame;
import cn.xpbootcamp.tennis.game4.Player;

import java.util.Arrays;

public class DefaultDisplayRule extends BaseScoreDisplayRule {
    @Override
    public String getDisplayStr(MyTennisGame game) {
        Integer[] scores = Arrays.stream(game.getPlayers())
                .mapToInt(Player::getScore)
                .boxed()
                .toArray(Integer[]::new);

        if (scores[0].equals(scores[1])) {
            return ScoreDesc.getDescStr(scores[0]) + "-All";
        }

        return ScoreDesc.getDescStr(scores[0]) + "-" + ScoreDesc.getDescStr(scores[1]);
    }

    @Override
    public boolean test(MyTennisGame game) {
        return getLeadingPlayer(game).getScore() <= 3
                && getLaggingPlayer(game).getScore() <= 3;
    }
}

