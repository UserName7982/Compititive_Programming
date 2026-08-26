package CodeForces;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            k--;

            int low=1;
            int high=n;
            while (low<high) {
                int mid=(low+high+1)/2;
                long ans=Long.MAX_VALUE;
                for (int l = 0,r=mid-1; r<n; l++,r++) {
                    if (l>k) {
                        break;
                    }
                    if (r<k) {
                        continue;
                    }
                    long left=k-l;
                    long right=r-k;
                    ans=Math.min(ans, left-1+Math.max(left,right)+right);
                }
                if (ans<=m) {
                    low=mid;
                }else{
                    high=mid-1;
                }
            }
            System.out.println(low);
        }
    }
}