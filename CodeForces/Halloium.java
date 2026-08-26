package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class Halloium {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }
            int[] temp=Arrays.copyOf(arr, n);
            Arrays.sort(arr);
            if (Arrays.equals(arr, temp)) {
                System.out.println("YES");
            }
            else if (k<=1) {
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
