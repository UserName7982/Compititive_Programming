package CodeForces._1000Rated;

import java.util.Arrays;
import java.util.Scanner;

public class Basketball_Together {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            int i = n - 1;
            int ans = 0;
            while (n > 0) {
                long numofmembers = (long) Math.ceil((1.0 * d) / (arr[i] * 1.0));
                if (numofmembers > n) {
                    break;
                } else {
                    if (numofmembers < n && numofmembers * arr[i] == d) {
                        numofmembers++;
                    }
                }
                if (numofmembers * arr[i] > d) {
                    ans++;
                }
                n -= numofmembers;
                i--;
            }
            System.out.println(ans);
        }
}
