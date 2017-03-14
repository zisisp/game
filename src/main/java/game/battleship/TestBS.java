package game.battleship;

/**
 * Created by zpontikas on 3/12/2017.
 */
public class TestBS {
    public static void main(String[] args) {
        Solution a1 = new Solution();
        String ships1 = "1B 2C,2D 4D";
        String hits1 = "2B 2D 3D 4D 4A";
        String ships2 = "1A 1B,2C 2C";
        String hits2 = "1B";
        String ships3 = "1A 2A,12A 12A";
        String hits3 = "12A";
        int n1 = 4;
        int n2 = 3;
        int n3 = 12;
        String solution = a1.solution(n1, ships1, hits1);
        String solution2 = a1.solution(n2, ships2, hits2);
        String solution3 = a1.solution(n3, ships3, hits3);
        System.out.println("solution = " + solution + " " + solution.equals("1,1"));
        System.out.println("solution2 = " + solution2 + " " + solution2.equals("0,1"));
        System.out.println("solution3 = " + solution3 + " " + solution3.equals("1,0"));
    }
}
