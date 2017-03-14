import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            integers.add(in.nextInt());
        }
        System.out.println(integers.stream().reduce(0,Integer::sum));
    }

}