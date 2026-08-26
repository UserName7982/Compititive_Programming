package CodeForces; 
import java.io.*;
import java.util.*;

public class Stamina_and_Tasks {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int[] c = new int[n];
            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                c[i] = fs.nextInt();
                p[i] = fs.nextInt();
            }

            double dp = 0.0;

            for (int i = n - 1; i >= 0; i--) {
                double q = 1.0 - p[i] / 100.0;
                dp = Math.max(dp, c[i] + q * dp);
            }

            out.append(String.format(Locale.US, "%.10f%n", dp));
        }

        System.out.print(out);
    }

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
}