package CodeForces;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            long x = fs.nextLong();

            long base = 0L;
            long maxS = Long.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                long a = fs.nextLong();
                long b = fs.nextLong();
                long c = fs.nextLong();

                // base contribution: (b-1)*a (uses without any rollback)
                base = safeAdd(base, safeMul(Math.max(0L, b - 1L), a));

                // s = b*a - c
                long s = safeSub(safeMul(b, a), c);
                if (s > maxS) maxS = s;
            }

            if (base >= x) {
                sb.append(0).append('\n');
            } else {
                long need = x - base;
                if (maxS <= 0) {
                    sb.append(-1).append('\n');
                } else {
                    long ans = (need + maxS - 1) / maxS; // ceil division
                    sb.append(ans).append('\n');
                }
            }
        }

        System.out.print(sb.toString());
    }

    // helper safe operations (useful to be robust; not strictly necessary here)
    static long safeMul(long a, long b) {
        return a * b;
    }
    static long safeAdd(long a, long b) {
        return a + b;
    }
    static long safeSub(long a, long b) {
        return a - b;
    }

    // fast scanner
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
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return Long.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}
