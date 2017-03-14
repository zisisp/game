import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Solution4 {

    public static final String STRING_EXPECTED =  "String:   fsdfsdf   sdf";
    public static final String DOUBLE_EXPECTED =  "Double: 2.3534534534523453E11";
    public static final String INTEGER_EXPECTED = "Int: 2147483647";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d=scan.nextDouble();
        scan.nextLine();
        String s2=scan.nextLine();
        System.out.println("s2 = " + s2);
        NumberFormat nf=new DecimalFormat("#############.#############");
        // Write your code here.

        String stringInput = "String: " + s2;
        System.out.println(stringInput);
        String doubleInput = "Double: " + nf.format(d);
        System.out.println(doubleInput);
        System.out.println("Double: " + d);
        String intInput = "Int: " + i;
        System.out.println(stringInput);
        validate(intInput, doubleInput, stringInput, INTEGER_EXPECTED, DOUBLE_EXPECTED, STRING_EXPECTED);
    }

    private static void validate(String intInput, String doubleInput, String stringInput, String integerExpected, String doubleExpected, String stringExpected) {
        System.out.println("integer= " + intInput.equals(integerExpected));
        System.out.println("double= " + doubleInput.equals(doubleExpected));
        System.out.println("string= " + stringInput.equals(stringExpected));
    }

}
//String:   fsdfsdf   sdf
//Double: 2.3534534534523453E11
//Double: 235345345345.234534
//Int: 2147483647