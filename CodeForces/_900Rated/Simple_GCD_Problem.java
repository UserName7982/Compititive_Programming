package CodeForces._900Rated;
import java.util.*;

public class Simple_GCD_Problem {

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) a[i] = sc.nextLong();
            for (int i = 0; i < n; i++) b[i] = sc.nextLong();

            // Precompute gcd constraints
            long[] g = new long[n - 1];
            for (int i = 0; i < n - 1; i++) {
                g[i] = gcd(a[i], a[i + 1]);
            }

            int ans = 0;

            long prev = a[0]; // start with original first

            // try changing first element
            if (n > 1) {
                long m = g[0];
                if (m <= b[0] && m != a[0] &&
                    gcd(m, a[1]) == g[0]) {
                    prev = m;
                    ans++;
                }
            }

            for (int i = 1; i < n; i++) {

                long take = a[i];

                // try change
                long m;
                if (i == n - 1) {
                    m = g[i - 1];
                } else {
                    m = g[i - 1];
                }

                boolean changed = false;

                if (m <= b[i] && m != a[i] &&
                    gcd(prev, m) == g[i - 1]) {

                    // also check right side if exists
                    if (i == n - 1 || gcd(m, a[i + 1]) == g[i]) {
                        take = m;
                        changed = true;
                        ans++;
                    }
                }

                // fallback to original
                if (!changed) {
                    take = a[i];
                }

                prev = take;
            }

            System.out.println(ans);
        }
    }
}