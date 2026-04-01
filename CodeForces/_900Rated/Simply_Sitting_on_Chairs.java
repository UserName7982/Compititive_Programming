package CodeForces._900Rated;
<<<<<<< HEAD
import java.io.*;
import java.util.*;

public class Simply_Sitting_on_Chairs {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            int[] end = new int[n + 2];

            for (int i = 1; i <= n; i++) {
                int p = fs.nextInt();
                if (p > i) {
                    end[p]++;
                }
            }

            int bad = 0;
            int ans = 0;

            for (int m = 0; m <= n; m++) {
                if (m > 0) bad += end[m];
                ans = Math.max(ans, m - bad);
            }

            out.append(ans).append('\n');
        }

        System.out.print(out.toString());
=======
import java.util.*;

public class Simply_Sitting_on_Chairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int minP = Integer.MAX_VALUE;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                minP = Math.min(minP, p[i]);

                if (minP >= i + 1) {
                    ans++;
                } else {
                    break;
                }
            }

            System.out.println(ans);
        }
>>>>>>> d60e6b16f8b0c86f42c4f819365805bb603b2acd
    }
}