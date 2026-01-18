package InclusionExclusion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class countGCD {
    static int MOD=998244353;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long M=sc.nextLong();
            int[] arr=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }

            boolean ok=true;
            for (int i = 1; i < n; i++) {
                if (arr[i-1] % arr[i] != 0) {
                    ok=false;
                    break;
                }
            }
            if (!ok) {
                System.out.println(0);
                continue;
            }

            long ans = 1;

            for (int i = 1; i < n; i++) {

                long x = arr[i-1] / arr[i];
                long range = M / arr[i];

                List<Long> pf = primeFactor(x);
                long ways = countCoprime(range, pf);

                ans = ans * ways % MOD;
            }
            System.out.println(ans);
        }
    }

    // Inclusion-Exclusion
    private static long countCoprime(long range, List<Long> pf) {
        long total = range;
        int n = pf.size();
        int subset = 1 << n;

        for (int mask = 1; mask < subset; mask++) {
            long prod = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    long p = pf.get(i);
                    if (prod > range / p) {
                        prod = range + 1; 
                        break;
                    }
                    prod *= p;
                    bits++;
                }
            }

            if (prod > range) continue;

            long div = range / prod;

            if (bits % 2 == 1) total -= div;
            else total += div;
        }
        return total;
    }

    private static List<Long> primeFactor(long x) {
        List<Long> pf = new ArrayList<>();
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                pf.add(i);
                while (x % i == 0) x /= i;
            }
        }
        if (x > 1) pf.add(x);
        return pf;
    }
}
