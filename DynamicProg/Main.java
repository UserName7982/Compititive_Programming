package DynamicProg;
import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long)9e18;
    static String s;
    static long[] cost;
    static long[][] memo; 
    static int n;
    static final String HARD = "hard";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        s = br.readLine().trim();
        cost = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cost[i] = Long.parseLong(st.nextToken());

        memo = new long[n][4];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1L);

        long ans = dfs(0, 0);
        System.out.println(ans);
    }

    static long dfs(int i, int j) {
        if (j >= 4) {
            return INF;
        }
        if (i == n) {
            return 0L;
        }
        if (memo[i][j] != -1L) return memo[i][j];

        char ch = s.charAt(i);
        long ans = INF;

        if (ch == HARD.charAt(j)) {
            long deleteCost = cost[i] + dfs(i + 1, j);
            ans = Math.min(ans, deleteCost);

            if (j + 1 < 4) {
                long keepCost = dfs(i + 1, j + 1);
                ans = Math.min(ans, keepCost);
            } else {
            }
        } else {
            ans = Math.min(ans, dfs(i + 1, j));
        }

        memo[i][j] = ans;
        return ans;
    }
}

/**
 *import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long)9e18;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        long[] cost = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cost[i] = Long.parseLong(st.nextToken());

        final String HARD = "hard";

        // dp[i][j] = minimum cost to handle suffix starting at i,
        // given we've already kept j characters of "hard"
        // i in 0..n, j in 0..3. dp[n][*] = 0.
        long[][] dp = new long[n + 1][4];
        for (int j = 0; j < 4; j++) dp[n][j] = 0L;

        // fill dp bottom-up
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            for (int j = 0; j < 4; j++) {
                if (ch == HARD.charAt(j)) {
                    // option 1: delete this char
                    long deleteCost = cost[i] + dp[i + 1][j];
                    // option 2: keep this char -> advance j (unless it completes "hard")
                    long keepCost = (j + 1 < 4) ? dp[i + 1][j + 1] : INF;
                    dp[i][j] = Math.min(deleteCost, keepCost);
                } else {
                    // char doesn't affect j
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
**/ 
