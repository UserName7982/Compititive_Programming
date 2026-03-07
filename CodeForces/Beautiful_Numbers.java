package CodeForces;
import java.util.*;

public class Beautiful_Numbers {
    static final int LIM = 2_000_005; // enough because n+m <= 2e6
    static int[] freq = new int[LIM];
    static int[] mark = new int[LIM]; // timestamp for "good"
    static int testId = 1;

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // lcm capped: if exceeds cap, return cap+1
    static long lcmCapped(long a, long b, long cap) {
        long g = gcd(a, b);
        long x = a / g;
        if (x > cap / b) return cap + 1;
        long res = x * b;
        return (res > cap) ? cap + 1 : res;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int maxV = n + m;

            int[] uniq = new int[n];
            int uq = 0;

            long L = 1;

            for (int i = 0; i < n; i++) {
                int v = fs.nextInt();
                if (freq[v] == 0) uniq[uq++] = v;
                freq[v]++;
                if (L <= maxV) L = lcmCapped(L, v, maxV);
            }

            // mark all multiples of any a[i]
            for (int i = 0; i < uq; i++) {
                int v = uniq[i];
                for (int mul = v; mul <= maxV; mul += v) {
                    mark[mul] = testId; // good[mul] = true for this test
                }
            }

            long A = 0, B = 0, C = 0;
            for (int i = 0; i < m; i++) {
                int y = fs.nextInt();
                if (mark[y] != testId) {
                    B++; // Bob-only
                } else if (L <= maxV && y % L == 0) {
                    A++; // Alice-only
                } else {
                    C++; // Both
                }
            }

            // clear freq
            for (int i = 0; i < uq; i++) freq[uniq[i]] = 0;

            if (A > B) out.append("Alice\n");
            else if (A < B) out.append("Bob\n");
            else out.append((C % 2 == 1) ? "Alice\n" : "Bob\n");

            testId++;
        }

        System.out.print(out);
    }

    // fast scanner
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final java.io.InputStream in;
        FastScanner(java.io.InputStream in) { this.in = in; }
        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (Exception e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        long nextLong() {
            int c;
            do c = read(); while (c <= ' ' && c != -1);
            long sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            long x = 0;
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sgn;
        }
        int nextInt() { return (int) nextLong(); }
    }
}