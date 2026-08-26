package CodeForces;
import java.io.*;
import java.util.*;

public class Arraypermutaion {

    // Fast input
    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Long.MIN_VALUE;
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = fs.nextInt();
             while (t-- > 0) {
            int n = fs.nextInt();

            int[] pos = new int[n + 1]; // pos[value] = index in p (1-based)
            for (int i = 1; i <= n; i++) {
                int v = fs.nextInt();
                pos[v] = i;
            }

            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = fs.nextInt();

            // compress a into block values
            int prev = -1;
            int lastPos = 0;
            boolean ok = true;

            boolean[] seen = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                if (a[i] == prev) continue; // same block
                int v = a[i];
                prev = v;

                // value appears in multiple blocks -> impossible
                if (seen[v]) { ok = false; break; }
                seen[v] = true;

                int pv = pos[v];
                if (pv <= lastPos) { ok = false; break; }
                lastPos = pv;
            }

            sb.append(ok ? "YES\n" : "NO\n");
        }
        System.out.print(sb.toString());
    }
}
