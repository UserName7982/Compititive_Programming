package ModularArithmetic;

import java.util.Scanner;

public class VasilyBear {

    public static int MOD = (int)1e9 + 7;
    static int[] fact, inverfact;

    public static int binaryExpoentiation(int a, int b, int mod){
        int ans = 1;
        while(b > 0){
            if ((b & 1) == 1) ans = (int)((1L * ans * a) % mod);
            a = (int)((1L * a * a) % mod);
            b >>= 1;
        }
        return ans;
    }

    static int C(int n, int r){
        if (r < 0 || r > n) return 0;
        return (int)(1L * fact[n] * inverfact[r] % MOD * inverfact[n - r] % MOD);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int g = sc.nextInt();

        int max = n + m + 5;
        fact = new int[max];
        inverfact = new int[max];

        fact[0] = 1;
        for(int i=1;i<max;i++) fact[i] = (int)(1L * fact[i-1] * i % MOD);

        inverfact[max-1] = binaryExpoentiation(fact[max-1], MOD-2, MOD);
        for(int i=max-2;i>=0;i--)
            inverfact[i] = (int)(1L * inverfact[i+1] * (i+1) % MOD);

        int ans = 0;

        for(int i=0;i<=n;i++){
            if (i % 2 != g) continue;   // ✔ FIXED
            System.out.println(i);
            int ways = C(n - i + m - 1, m - 1);
            System.out.println(ans);
            ans = (ans + ways) % MOD;
        }

        System.out.println(ans);
    }
}
