package CodeForces;

import java.util.Scanner;

public class MaxNeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] corr = { 1, 0, -1, 0 };
        int[] corry = { 0, 1, 0, -1 };

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int num = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = num++;
                }
            }

            int val=arr[n-1][n-2];
            int val1=arr[n-2][n-2];
            int[] vals={val,val1};
            int[][] corr1={{n-1,n-2},{n-2,n-2}};
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < 4; i++) {
                    int newx = corr1[k][0] + corr[i];
                    int newy = corr1[k][1] + corry[i];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < n) {
                        vals[k]+=arr[newx][newy];
                    }
                }
            }
            System.out.println(Math.max(vals[0],vals[1]));
        }
    }
}
