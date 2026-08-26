package CodeForces;

import java.util.Scanner;

public class DBMS {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int s=sc.nextInt();
            int x=sc.nextInt();

            int[] arr=new int[n];
            int sum=0;
            for (int i = 0; i < n; i++) {
                sum+=sc.nextInt();
            }
            int rem=s-sum;
            if (sum==s) {
                System.out.println("YES");
            }
            else if (rem>0 && (rem%x==0)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
