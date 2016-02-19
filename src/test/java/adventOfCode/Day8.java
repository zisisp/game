package adventOfCode;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zep
 * Date: 19/2/2016
 * Time: 12:23 μμ
 * Company: www.xe.gr
 */
public class Day8 {
    public static final String test1="\"\"";
    public static final String test2="\"abc\"";
    public static final String test3="\"aaa\\\"aaa\"";
    public static final String test4="\"\\x27\"";
    public static final String test5="\"zf\\x23\\\\hlj\\\\kkce\\\\d\\\\asy\\\"yyfestwcdxyfj\"\n";

    public static void main(String[] args) throws IOException {
//        int count1=countCharactersForString(test1);
//        int count2=countCharactersForString(test2);
//        int count3=countCharactersForString(test3);
//        int count4=countCharactersForString(test4);
//        int count5=countCharactersForString(test5);
        List<String> lines= Arrays.asList(new String(Files.readAllBytes(Paths.get("C:\\Users\\zep\\IdeaProjects\\game\\src\\test\\java\\adventOfCode","day8.txt"))).split("\n"));
        int total=lines.stream().mapToInt(String::length).sum();
        int chars=lines.stream()
                .map(x -> x.replace("\"","A"))
                .map(x -> x.replace("\\\\","A"))
                .map(x -> x.replace("\\\\x[a-fA-F0-9]{2}","A"))
                .mapToInt(String::length)
                .sum();
        int result=total-chars;
        String r= StringEscapeUtils.escapeJava(test5);
        System.out.println("5 = " + test5);
        System.out.println("r = " + r);
        System.out.println("result = " + result);
        int sum2=0;
        for (String line : lines) {
            sum2+=line.length();
        }
        System.out.println("sum2 = " + sum2);
    }
}