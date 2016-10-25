/**
 * Created by prajena on 9/23/2016.
 */
public class TestA {
    public static void main(String[] args) {
       /* toA2Z(0);
        toA2Z(1);
        toA2Z(26);
        toA2Z(51);
        toA2Z(52);
        toA2Z(77);
        toA2Z(78);
        toA2Z(79);
        toA2Z(676);
        toA2Z(701);
        toA2Z(702);
        toA2Z(1299);*/
        toA2Z(16383);
    }

    public static void toA2Z(int n) {
        int n1 = n;
        if (n == 0) {
            System.out.println(n1 + " : " + "A");
            return;
        }
        StringBuilder s = new StringBuilder();
        int sign = 9;
        while (n > 0) {
            int r = -1;
            if (n >=26) {
                sign = 1; // LMS
            } else if (n < 26) {
                sign = 9; // RMS
            } else
                sign = 5; // Middle
            if (sign == 9) {
                r = n % 26;
                n /= 26;
            } else {
                r = n % 27;
                n /= 27;
            }
            s.insert(0, resolveAscii(r, sign));
        }
        System.out.println(n1 + " : " + s);
    }

    private static char resolveAscii(int r, int sign) {
        if (sign == 9 || sign == 5) {
            return (char) (r + 65);
        }
        return (char) (r + 64);
    }

}
