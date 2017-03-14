import java.util.Arrays;
import java.util.List;

/**
 * Created by zpontikas on 3/12/2017.
 */
public class ElevatorTest {

    public static int[] A1= {60,80,40};
    public static int[] B1= {2,3,5};
    public static int[] A2= {40,40,100,80,20};
    public static int[] B2= {3,3,2,2,3};
    Solution.Elevator elevator1=new Solution.Elevator(2,200, 5);
    Solution.Elevator elevator2=new Solution.Elevator(5,200, 5);
    public static void main(String[] args) {
        Solution solution=new Solution();
        int sol1=solution.solution(A1,B1,5,2,200);
        int sol2=solution.solution(A2,B2,5,5,200);
        System.out.println("sol1 = " + sol1);
        System.out.println("sol2 = " + sol2);
    }
}
