package CodeForces;

import java.util.Scanner;

public class XORconvineance {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            arr[n-1]=1;
            for (int i = 1; i <n-1 ; i++) {
                arr[i]=i^1;
            }
            arr[0]=(n%2==0)? n:n-1;
            for (int i = 0; i < arr.length; i++) {
               System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
