package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class Deletion_Sort {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            int n=sc.nextInt();
            int[] arr=new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            int[] temp=Arrays.copyOf(arr,n);
            Arrays.sort(arr);
            if (Arrays.equals(temp,arr)) {
                System.out.println(n);
            }
            else{
                System.out.println(1);
            }
       
        }
    }
}
