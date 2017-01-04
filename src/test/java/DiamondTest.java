import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiamondTest {
    @Test
    public void testDiamond3() {
        StringBuffer expected = new StringBuffer();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");
        System.out.println("Diamond.print3 = \n" + Diamond.print(3));
        assertEquals(expected.toString(), Diamond.print(3));
    }

    @Test
    public void testDiamond5() {
        StringBuffer expected = new StringBuffer();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");
        System.out.println("Diamond.print5 = \n" + Diamond.print(5));
        assertEquals(expected.toString(), Diamond.print(5));
    }

    @Test
    public void testDiamond7() {
        StringBuffer expected = new StringBuffer();
        expected.append("   *\n");
        expected.append("  ***\n");
        expected.append(" *****\n");
        expected.append("*******\n");
        expected.append(" *****\n");
        expected.append("  ***\n");
        expected.append("   *\n");
        System.out.println("Diamond.print7 = \n" + Diamond.print(7));
        assertEquals(expected.toString(), Diamond.print(7));
    }
}