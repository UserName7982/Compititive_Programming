package CodeForces._900Rated;

import java.util.Arrays;
import java.util.Scanner;

public class Flip_Flops {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            long c=(long)sc.nextInt();
            int k=sc.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]<=c){
                    if(Math.abs(arr[i]-c)<=k && k>0){
                        k-=Math.abs(arr[i]-c);
                        c*=2;  
                    }else if (k>0) {
                        c+=arr[i]+k;
                        k=0;
                    }else{
                        c+=arr[i];
                    }
                }
            }
            System.out.println(c);
        }
    }
}
