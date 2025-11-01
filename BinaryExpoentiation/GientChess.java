package BinaryExpoentiation;

import java.util.Arrays;
import java.util.Scanner;

public class GientChess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int b = sc.nextInt();

        int[][] black = new int[b][2];

        for (int i = 0; i < b; i++) {
            black[i][0] = sc.nextInt();
            black[i][1] = sc.nextInt();
        }

        Arrays.sort(black, (a, c) -> a[0] == c[0] ? a[1] - c[1] : a[0] - c[0]);
        int MOD = 1000000007;
        int maxfact = h + w + 1;

        long fact[] = new long[h + w + 1];
        fact[0] = 1;
        for (int i = 1; i < maxfact; i++) {
            fact[i] = (fact[i - 1] * i + MOD) % MOD;
        }
        iterative it = new iterative();
        long inverFact[] = new long[h + w + 1];
        inverFact[maxfact - 1] = (long) it.binaryExpoentiation(fact[maxfact - 1], MOD - 2, MOD);
        for (int i = maxfact - 2; i >= 0; i--) {
            inverFact[i] = (inverFact[i + 1] * (i + 1) + MOD) % MOD;
        }

        long dp[] = new long[h + w + 1];
        for (int i = 0; i < b; i++) {
            int x = black[i][0];
            int y = black[i][1];
            dp[i] = fact[x + y - 2] % MOD * inverFact[x - 1] % MOD * inverFact[y - 1] % MOD;

            for (int j = 0; j < i; j++) {
                int x1 = black[j][0];
                int y1 = black[j][1];
                if (x1 <= x && y1 <= y) {
                    long val = dp[j] * fact[x - x1 + y - y1] % MOD * inverFact[x - x1] % MOD * inverFact[y - y1] % MOD;
                    dp[i] = (dp[i] - val + MOD) % MOD;
                }
            }
        }

        long ans = fact[h + w - 2] * inverFact[h - 1] % MOD * inverFact[w - 1] % MOD;

        for (int i = 0; i < b; i++) {
            int x1 = black[i][0];
            int y1 = black[i][1];
            long val = dp[i] * fact[h - x1 + w - y1] % MOD * inverFact[h - x1] % MOD * inverFact[w - y1] % MOD;
            ans = (ans - val + MOD) % MOD;
        }
        System.out.println(ans);
        sc.close();
    }
}
