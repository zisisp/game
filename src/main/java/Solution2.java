import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println("LookAndSay(1) = " + LookAndSay("11",3).equals("312211"));
        System.out.println("LookAndSay(1) = " + LookAndSay("11",3));
    }

    static String LookAndSay(String s, int i) {
        if (i > 1) {
            return LookAndSay(LookAndSay(s),i-1);
        }
        else return LookAndSay(s);
    }


    static String LookAndSay(String start) {

        char[] start1=start.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for (char c : start1) {
            if (map.get(c) != null) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        List<Character> keys=new ArrayList<>(map.keySet());
        Collections.sort(keys, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2-o1;
            }
        });
        StringBuffer sb=new StringBuffer();
        for (Character key : keys) {
            sb.append(map.get(key)).append("").append(key);
        }
        return sb.toString();
    }
}
