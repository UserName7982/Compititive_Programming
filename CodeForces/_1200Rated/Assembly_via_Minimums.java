// package CodeForces._1200Rated;

import java.util.Arrays;
import java.util.Scanner;

public class Assembly_via_Minimums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = n * (n - 1) / 2;
            int[] arr = new int[x];
            for (int i = 0; i < x; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            int[] ans = new int[n];

            int idx = 0;
            for (int i = 0; i < n - 1; i++) {
                ans[i] = arr[idx];
                idx += (n - i - 1);
            }

            ans[n - 1] = 1000000000;

            for (int i : ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
