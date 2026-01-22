package CodeForces;
import java.io.*;
import java.util.*;

public class main {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do c = read(); while (c <= ' ');
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            do c = read(); while (c <= ' ');
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }

        String next() throws IOException {
            int c;
            do c = read(); while (c <= ' ');
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();

            long[] robots = new long[n];
            HashMap<Long, Integer> index = new HashMap<>();
            for (int i = 0; i < n; i++) {
                robots[i] = fs.nextLong();
                index.put(robots[i], i);
            }

            long[] spikes = new long[m];
            for (int i = 0; i < m; i++) spikes[i] = fs.nextLong();

            String gdCode = fs.next();

            long[] offset = new long[k + 1];
            for (int i = 1; i <= k; i++) {
                offset[i] = offset[i - 1] + (gdCode.charAt(i - 1) == 'L' ? -1 : 1);
            }

            HashMap<Long, Integer> first = new HashMap<>();
            for (int i = 1; i <= k; i++) {
                first.putIfAbsent(offset[i], i);
            }

            int INF = k + 1;
            int[] death = new int[n];
            Arrays.fill(death, INF);

            for (long s : spikes) {
                for (Map.Entry<Long, Integer> e : first.entrySet()) {
                    long need = s - e.getKey();
                    Integer idx = index.get(need);
                    if (idx != null) {
                        death[idx] = Math.min(death[idx], e.getValue());
                    }
                }
            }

            int[] diedAt = new int[k + 2];
            for (int i = 0; i < n; i++) {
                if (death[i] <= k) diedAt[death[i]]++;
            }

            int dead = 0;
            for (int i = 1; i <= k; i++) {
                dead += diedAt[i];
                out.append(n - dead).append(' ');
            }
            out.append('\n');
        }

        System.out.print(out.toString());
    }
}
