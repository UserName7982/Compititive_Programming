package Prime;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GoodSequence {
    static Set<Integer> primeFactors(int n){
        Set<Integer> set=new HashSet<>();
        for (int i = 2; i*i <= n; i++) {
            while (n%i==0) {
                set.add(i);
                n=n/i;
            }
        }
        if (n>1) {
            set.add(n);
        }
        return set;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int max=0;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            max=Math.max(max, arr[i]);
        }
        int[] dp=new int[max+1];
        int best[]=new int[max+1];

        for (int i = 0; i < n; i++) {
            Set<Integer> set=primeFactors(arr[i]);
            int max1=0;
            for (int num: set) {
                max1=Math.max(max1, best[num]);
            }
            dp[arr[i]]=Math.max(max1+1, dp[arr[i]]);
            for (int num: set) {
                best[num]=dp[arr[i]];
            }
        }
        int ans=0;
        for (int i = 0; i < dp.length; i++) {
            ans=Math.max(ans, dp[i]);
        }
        System.out.println(ans);
        sc.close();
    }
}
