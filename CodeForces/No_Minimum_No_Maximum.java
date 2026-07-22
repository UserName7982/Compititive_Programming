package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class No_Minimum_No_Maximum {
    static int MOD = (int) 1e9 + 7;
    static long[] fact;
    static long[] invfact;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            fact = new long[n + 1];
            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = i * fact[i - 1];
                fact[i] %= MOD;
            }
            invfact = new long[n + 1];
            invfact[n] = binaryExpoentiation(fact[n], MOD - 2);
            for (int i = n - 1; i >= 0; i--) {
                invfact[i] = invfact[i + 1] * (i + 1);
                invfact[i] %= MOD;
            }
            Arrays.sort(arr);
            long[] cnt = new long[n + 1];
            for (int i = 2; i < n; i++) {
                for (int l = 1; l <= k - 2; l++) {
                    long ways = C(i - 1, l);
                    ways = ways * C(n - i, k - 1 - l) % (MOD - 1);
                    cnt[i] = (cnt[i] + ways) % (MOD - 1);
                }
            }
            long res = 1;

            for (int i = 2; i < n; i++) {
                res = (res * binaryExpoentiation((long) arr[i], cnt[i])) % MOD;
            }
            System.out.println(res % MOD);
        }
    }

    static long C(int n, int r) {
        if (r < 0 || r > n)
            return 0;
        return fact[n] * invfact[r] % MOD * invfact[n - r] % MOD;
    }

    static long binaryExpoentiation(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
}
