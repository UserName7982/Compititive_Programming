package CodeForces._1500Rated;
import java.util.*;

public class Grid_Covering {
    static long gcd(long x, long y) {
        while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            if (gcd(n, a) == 1 && gcd(m, b) == 1 && gcd(n, m) <= 2) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }
}