package CodeForces._900Rated;

import java.util.Scanner;

public class A_Simple_Sequence {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            System.out.print(n-1+" ");
            System.out.print(n+" ");
            for (int i = n-2; i >0; i--) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}