package CodeForces;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RestrictedSort {
    

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
            int ans=Integer.MAX_VALUE;
            Arrays.sort(arr);
            if (Arrays.equals(temp,arr)) {
                ans=-1;
            }else{
                for (int i = 0; i < temp.length; i++) {
                    if (arr[i]!=temp[i]) {
                        int v=Math.max(Math.abs(temp[i]-arr[n-1]),Math.abs(temp[i]-arr[0]));
                ans=Math.min(ans, v);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
