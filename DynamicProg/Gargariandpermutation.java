package DynamicProg;

import java.util.Scanner;

public class Gargariandpermutation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] post = new int[k][n + 1];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                int val = scanner.nextInt();
                post[i][val] = j;
            }
        }

        int[] perm1 = new int[n];
        for (int i = 1; i <= n; i++) {
            perm1[post[0][i]] = i;
        }

        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int a = perm1[j];
                int b = perm1[i];


                boolean ok = true;
                for (int l = 1; l < k; l++) {
                    if (post[l][a] > post[l][b]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
        scanner.close();
    }
}
