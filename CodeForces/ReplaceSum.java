package CodeForces;

import java.util.Scanner;

public class ReplaceSum {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0) {
            int n=sc.nextInt();
            int q=sc.nextInt();
            int[] arr=new int[n];
            int[] arr1=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }
            for (int i = 0; i < arr1.length; i++) {
                arr1[i]=sc.nextInt();
            }
            for (int i = 0; i < arr1.length; i++) {
                if (i<n-1)
                arr[i]=Math.max(Math.max(arr[i],arr[i+1]),arr1[i]);
                else
                    arr[i]=Math.max(arr[i], arr1[i]);
            }
            for (int i = n-2; i >=0; i--) {
                arr[i]=Math.max(arr[i], arr[i+1]);
            }
            int[] prefix=new int[n];
            prefix[0]=arr[0];
            for (int i = 1; i < n; i++) {
                prefix[i]=prefix[i-1]+arr[i];
            }
             for (int i = 0; i < q; i++) {
                int l = sc.nextInt() - 1;
                int r = sc.nextInt() - 1;

                int ans = prefix[r] - (l > 0 ? prefix[l - 1] : 0);
                System.out.print(ans+" ");
            }
            System.out.println();
        }
    }
}
