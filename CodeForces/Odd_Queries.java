package CodeForces;

import java.util.Scanner;

public class Odd_Queries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = arr[0];
            int[] prefixSum = new int[n];
            prefixSum[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
                sum += arr[i];
            }
            for (int i = 0; i < q; i++) {
                            boolean isOdd = false;

                int l=sc.nextInt()-1;
                int r=sc.nextInt()-1;
                int k=sc.nextInt();
                int subArraySum = prefixSum[r] - (l > 0 ? prefixSum[l - 1] : 0);
                int newSum = sum - subArraySum + (r - l + 1) * k;
                if (newSum % 2 != 0) {
                    isOdd = true;
                }
                System.out.println(isOdd ? "YES" : "NO");
            }
            
        }
    }
}
