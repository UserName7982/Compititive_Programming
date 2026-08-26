package CodeForces;
import java.io.*;
import java.util.*;

public class Seats {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();

            int ones = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') ones++;
            }

            int add = 0;
            int i = 0;
            while (i < n) {
                if (s.charAt(i) == '1') {
                    i++;
                    continue;
                }
                int l = i;
                while (i < n && s.charAt(i) == '0') i++;
                int r = i - 1;
                int L = r - l + 1;

                boolean leftOne = (l - 1 >= 0 && s.charAt(l - 1) == '1');
                boolean rightOne = (r + 1 < n && s.charAt(r + 1) == '1');

                if (leftOne && rightOne) {
                    add += L / 3;
                } else if (leftOne || rightOne) {
                    add += (L + 1) / 3;
                } else {
                    add += (L + 2) / 3;
                }
            }

            out.append(ones + add).append('\n');
        }

        System.out.print(out.toString());
    }

    // Fast scanner
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            do { c = read(); } while (c <= ' ' && c != -1);
            while (c > ' ') {
                sb.append((char)c);
                c = read();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            do { c = read(); } while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
