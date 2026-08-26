package CodeForces;

import java.util.Scanner;

public class TwoPermutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            if (a+b+1<n  || (n==a && n==b)) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
