/**
 * Created with IntelliJ IDEA.
 * User: zep
 * Date: 4/1/2017
 * Time: 12:14 μμ
 * Company: www.xe.gr
 */
class Diamond {
    public static String print(int n) {
        if (n < 0 || n % 2 == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(getSpaces(n, i));
            sb.append(getDiamonds(n, i));
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String getDiamonds(int n, int i) {
        int diamonds;
        if (i <= n / 2) {
            diamonds = 1 + i * 2;
        } else {
            diamonds=n-((i-n/2)*2);
        }
        StringBuilder sb=new StringBuilder();
        for (int j = 0; j < diamonds; j++) {
            sb.append("*");
        }
        return sb.toString();
    }

    private static String getSpaces(int n, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < Math.abs(n/2-i); j++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}