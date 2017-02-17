package adventOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: zep
 * Date: 19/2/2016
 * Time: 12:23 μμ
 * Company: www.xe.gr
 */
public class Day8 {
    public static final String test1 = "\"\"";
    public static final String test2 = "\"abc\"";
    public static final String test3 = "\"aaa\\\"aaa\"";
    public static final String test4 = "\"\\x27\"";
    public static final String test5 = "\"j\\xd8\"";
    public static final String FILENAME = "day8_1.txt";
    public static final String TestFile="test_1.txt";

    public static void main(String[] args) throws IOException, URISyntaxException {
        Inner in = new Inner();
        in.countCharactersAndPrintResult(in.getLinesOfText(FILENAME), 1333,FILENAME);
        in.countCharactersAndPrintResult(Collections.singletonList(test1),2,test1);
        in.countCharactersAndPrintResult(Collections.singletonList(test2),2,test2);
        in.countCharactersAndPrintResult(Collections.singletonList(test3),3,test3);
        in.countCharactersAndPrintResult(Collections.singletonList(test4),5,test4);
        in.countCharactersAndPrintResult(Collections.singletonList(test5),5,test5);
        in.countCharactersAndPrintResult(in.getLinesOfText(TestFile),12,TestFile);
    }

}