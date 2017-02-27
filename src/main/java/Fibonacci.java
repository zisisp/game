/**
 * Created by zpontikas on 2/13/2017.
 */
public class Fibonacci {

    public static final String temp="123";
    public static void main(String[] args) {

        int n1=0;
        int n2=1;
        int n3=1;
        System.out.println("temp = " + temp);
        System.out.println(" i = 1" + " n3= 0");
        System.out.println(" i = 2" + " n3= 1");
        int total=0;
        int counter=0;
        while (n2 < 4000000) {
            n3=n1+n2;
            n1=n2;
            n2=n3;
            if (n3 % 2 != 0) {
                total+=n3;
            }
            counter++;
        }
        System.out.println("total = " + total);
        System.out.println("n3 = " + n3);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
