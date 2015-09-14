package game.logic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zais on 9/5/2015.
 */
public class Player {
    List<Integer> balls;
    Integer turns;
    String name;

    public Player(String name) {
        this.name = name;
        turns=0;
        balls=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            balls.add(6);
        }
        balls.add(0);
    }


}
