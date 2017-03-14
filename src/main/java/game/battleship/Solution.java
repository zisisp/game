package game.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpontikas on 3/12/2017.
 */

class Solution {
    public String solution(int N, String S, String T) {
        // write your code in Java SE 8
        List<Ship> ships = getShips(S, N);
        List<Hit> hits = getHits(T, N);
        System.out.println("hits = " + hits);
        System.out.println("ships = " + ships);
        int hitShips = 0;
        int sunkShips = 0;
        for (Ship ship : ships) {
            ship.calculateHits(hits);
            if (ship.isSunk()) {
                sunkShips++;
            } else if (ship.isHit()) {
                hitShips++;
            }
        }

        return sunkShips + "," + hitShips;
    }

    private List<Hit> getHits(String t, int n) {
        List<Hit> toReturn = new ArrayList<>(n);
        for (String s : t.split(" ")) {
            toReturn.add(new Hit(s));
        }
        return toReturn;
    }

    private List<Ship> getShips(String s, int n) {
        List<Ship> ships = new ArrayList<>(n);
        String[] shipString = s.split(",");
        for (String s1 : shipString) {
            ships.add(new Ship(new Hit(s1.split(" ")[0]), new Hit(s1.split(" ")[1]),s1));
        }
        return ships;
    }

    public class Ship {

        private final Hit topLef;
        private final Hit botRight;
        private final String initial;
        private int hits;
        private int shipArea;
        private int shitHits;

        public Ship(Hit topLeft, Hit botRight,String initial) {
            this.topLef = topLeft;
            this.botRight = botRight;
            shipArea = calcArea();
            this.initial=initial;
        }

        private int calcArea() {
            int length = Math.abs(topLef.x-botRight.x)+1;
            int width = Math.abs(topLef.y-botRight.y)+1;
            return length * width;
        }

        @Override
        public String toString() {
            return "Ship{" +
                    "topLef=" + topLef +
                    ", botRight=" + botRight +
                    ", hits=" + hits +
                    ", shipArea=" + shipArea +
                    ", shitHits=" + shitHits +
                    '}';
        }

        public void calculateHits(List<Hit> hits) {
            this.shitHits = 0;
            for (Hit hit : hits) {
                if (hit.x >= topLef.x && hit.x <= botRight.x) {
                    if (hit.y >= topLef.y && hit.y <= botRight.y) {
                        shitHits++;
                    }
                }
            }
        }

        public boolean isHit() {
            return shitHits> 0;
        }

        public boolean isSunk() {
            return shitHits== this.shipArea;
        }
    }

    public static class Hit {
        public final int x;
        public final int y;
        public final String intital;

        public Hit(String s) {
            x = (s.toUpperCase().charAt(1)) - ('A');
            y = (s.charAt(0)) - ('1');
            intital = s;
    }

        @Override
        public String toString() {
            return "Hit{" +
                    "x=" + x +
                    ", y=" + y +
                    ", intital='" + intital + '\'' +
                    '}';
        }
    }

}
