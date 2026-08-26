package CodeForces;

import java.util.Scanner;

public class UnfairGame {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int k=sc.nextInt();

            int mz=31-Integer.numberOfLeadingZeros(n);
            long ans=0;
            for (int i = 0; i < mz; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j*2 + (i-j)+1>k) {
                      ans+=nCr(i, j);  
                    }
                }
            }
            if (mz>=k) {
                ans++;
            }
            System.out.println(ans);
        }
    }

       static long nCr(int n, int r) {
        if (r > n) return 0;
        r = Math.min(r, n - r);

        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return res;
    }
}
