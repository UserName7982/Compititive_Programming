package CodeForces;

import java.util.Scanner;

public class AvtoBus {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            long n=sc.nextLong();

            long min=Long.MAX_VALUE;
            long max=Long.MIN_VALUE;
            max= n/4;
            min=(n+5)/6;
            if (n<4||n%2!=0) {
                System.out.println(-1);
                continue;
            }
            System.out.println((min)+" "+(max));
        }
    }
}