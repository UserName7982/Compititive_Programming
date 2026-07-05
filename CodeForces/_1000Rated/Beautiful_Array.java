package CodeForces._1000Rated;

import java.util.Scanner;

public class Beautiful_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt();
            long k=sc.nextLong();
            long b=sc.nextLong();
            long s=sc.nextLong();
            long[] arr = new long[n];
            long min=k*b;
            long max=(k*b)+(n*(k-1));
            if (min>s ||max<s) {
                System.out.println(-1);
                continue;
            }
            arr[0]=min;
            s-=min;
            for (int i = 0; i < n; i++) {
                long add=Math.min(s, k-1);
                arr[i]+=add;
                s-=add;
            }
            for (int i=0; i<n; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
