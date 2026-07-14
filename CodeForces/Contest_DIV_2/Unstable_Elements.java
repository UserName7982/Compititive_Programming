// package CodeForces.Contest_DIV_2;
import java.util.*;
import java.io.*;

public class Unstable_Elements {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = nextInt(in);
            long K = nextInt(in);
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt(in);

            int[] c = new int[n];
            int m = 0;
            int i = 0;
            while (i < n) {
                int j = i;
                while (j < n && a[j] == a[i]) j++;
                c[m++] = j - i;
                i = j;
            }

            int[] sorted = Arrays.copyOf(c, m);
            Arrays.sort(sorted);

            long[] suffixSum = new long[m + 1];
            for (int idx = m - 1; idx >= 0; idx--) suffixSum[idx] = suffixSum[idx + 1] + sorted[idx];

            long ans = 0;
            int idx = 0;
            while (idx < m) {
                int val = sorted[idx];
                long cnt = m - idx;
                long S = suffixSum[idx];

                long diff = K - S;
                if (diff >= 0 && diff % cnt == 0) {
                    long e = diff / cnt;
                    if (e >= 1 - (long) val) {
                        ans++;
                    }
                } else if (diff < 0) {
                    if (diff % cnt == 0) {
                        long e = diff / cnt;
                        if (e >= 1 - (long) val) {
                            ans++;
                        }
                    }
                }
                while (idx < m && sorted[idx] == val) idx++;
            }

            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        boolean neg = false;
        while (b != '-' && (b < '0' || b > '9')) b = in.read();
        if (b == '-') { neg = true; b = in.read(); }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }
}