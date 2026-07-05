package CodeForces._900Rated;

import java.util.Scanner;

public class Flip_the_Bit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int ans = 0;
            int p=sc.nextInt()-1;
            int prev=-1;
            int count1=0;
            int count2=0;
            for (int i = 0; i < p; i++) {
              if(prev==-1 && a[i]==a[p]){
                  continue;
              }
              else if(prev!=a[i]){
                  count1++;
              }
              prev=a[i];
            }
            prev=-1;
             for (int i = n-1; i >= p+1; i--) {
              if(prev==-1 && a[i]==a[p]){
                  continue;
              }
              else if(prev!=a[i]){
                  count2++;
              }
              prev=a[i];
            }
            ans=Math.max(count1, count2);
            System.out.println(ans%2==0?ans:ans+1);
        }
    }
}
