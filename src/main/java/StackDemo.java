import java.util.*;
public class StackDemo {

    static void showpush(Stack st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[]) {
        Stack st = new Stack();
        System.out.println("stack: " + st);
        showpush(st, 42);
        search(st,42);
        showpush(st, 66);
        search(st,42);
        showpush(st, 99);
        search(st,42);
        showpop(st);
        search(st,0);
        showpop(st);
        search(st,0);
        showpop(st);
        search(st,0);
        try {
            showpop(st);
        }catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }

    private static void search(Stack st, int i) {
        System.out.println("st.search() = " + st.search(i));
    }
}