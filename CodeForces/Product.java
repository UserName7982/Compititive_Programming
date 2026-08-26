package CodeForces;

import java.util.Scanner;

public class Product {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];
            boolean is67=false;
            boolean is1=false;
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
                if (arr[i]==67) {
                    is67=true;
                }
                if (arr[i]==1) {
                    is1=true;
                }
            }
            if (is1 && is67) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
