package game.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zais on 9/5/2015.
 */
public class Player {
    List<Integer> stones;
    Integer turns;
    String name;

    public Player(String name) {
        this.name = name;
        turns=0;
        stones =new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            stones.add(6);
        }
        stones.add(0);
    }

    public List<Integer> getStones() {
        return stones;
    }

    public void setStones(List<Integer> stones) {
        this.stones = stones;
    }

    public Integer getTurns() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns = turns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
