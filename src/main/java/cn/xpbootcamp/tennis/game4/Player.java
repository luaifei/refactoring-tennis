package cn.xpbootcamp.tennis.game4;

import lombok.Getter;

@Getter
public class Player {
    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void wonPoint() {
        score ++;
    }
}
