import java.io.*;
import java.util.*;

public class mar_and_Alternating_Sums {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int t = nextInt(in);
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = nextInt(in);
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong(in);
            }

            int m = 0;
            while (m < n && a[m] == -1) m++;

            int L = n - m;

            int g = 0;
            long D = 0;
            long prevVal = -2;
            int idx = m;

            long lastBlockValue = Long.MIN_VALUE;
            boolean hasLastBlock = false;

            while (idx < n) {
                long val = a[idx];
                int cnt = 0;
                while (idx < n && a[idx] == val) {
                    idx++;
                    cnt++;
                }
                g++;
                if (hasLastBlock && val - lastBlockValue == 1) {
                    D++;
                }
                lastBlockValue = val;
                hasLastBlock = true;
            }

            long Z0 = modpow(2, L - g, MOD);
            long Zm1 = (D % MOD) * Z0 % MOD;

            long E, O;
            if (m == 0) {
                E = 1;
                O = 0;
            } else {
                E = modpow(2, m - 1, MOD);
                O = E;
            }

            long ans = (E * Z0 % MOD + O * Zm1 % MOD) % MOD;
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static long modpow(long base, long exp, int mod) {
        base %= mod;
        if (base < 0) base += mod;
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == '-') break;
            b = in.read();
        }
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }

    private static long nextLong(DataInputStream in) throws IOException {
        long ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == '-') break;
            b = in.read();
        }
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -ret : ret;
    }
}