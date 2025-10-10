package DynamicProg;
import java.io.*;
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
        
        long[][] dp = new long[n + 1][4];
        for (int j = 0; j < 4; j++) dp[n][j] = 0L;

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            for (int j = 0; j < 4; j++) {
                if (ch == HARD.charAt(j)) {
                    long deleteCost = cost[i] + dp[i + 1][j];
                    long keepCost = (j + 1 < 4) ? dp[i + 1][j + 1] : INF;
                    dp[i][j] = Math.min(deleteCost, keepCost);
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
