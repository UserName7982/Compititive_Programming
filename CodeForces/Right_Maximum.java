package CodeForces;

import java.util.Scanner;

public class Right_Maximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            int maxSoFar = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x >= maxSoFar) {
                    ans++;
                    maxSoFar = x;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}