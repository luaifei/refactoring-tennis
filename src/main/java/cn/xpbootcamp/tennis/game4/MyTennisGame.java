package cn.xpbootcamp.tennis.game4;

import cn.xpbootcamp.tennis.TennisGame;
import cn.xpbootcamp.tennis.game4.displayrule.*;

import java.util.Arrays;
import java.util.List;

public class MyTennisGame implements TennisGame {
    private Player[] players;
    private List<ScoreDisplayRule> ruleList = Arrays.asList(new WonDisplayRule(),
            new DeuceDisplayRule(), new AdvantageRule(), new DefaultDisplayRule());

    public MyTennisGame(String player1Name, String player2Name) {
        players = new Player[] {new Player(player1Name), new Player(player2Name)};
    }

    public Player[] getPlayers() {
        return Arrays.copyOf(players, players.length);
    }

    @Override
    public void wonPoint(String playerName) {
        Arrays.stream(players)
                .filter(player -> playerName.equals(player.getName()))
                .findFirst()
                .ifPresent(Player::wonPoint);
    }

    @Override
    public String getScore() {
        return ruleList.stream()
                .filter(rule -> rule.test(this))
                .findFirst()
                .map(scoreDisplayRule -> scoreDisplayRule.getDisplayStr(this))
                .get();
    }
}


