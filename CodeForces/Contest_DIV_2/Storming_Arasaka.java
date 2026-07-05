package CodeForces.Contest_DIV_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Storming_Arasaka {
    static final int MAX = 1_000_000;
    static int[] spf = new int[MAX + 1];
     static void sieve() {
        for (int i = 0; i <= MAX; i++) spf[i] = i;
        for (int i = 2; i * i <= MAX; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sieve();

        int t = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int ans = 0;
            while (n > 1) {
                ans++;
                n /= spf[n];
            }
            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}
