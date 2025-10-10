package DynamicProg;
import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long)9e18;
    static String s;
    static long[] cost;
    static long[][] memo; // memo[i][j] for i in [0..n-1], j in [0..3]
    static int n;
    static final String HARD = "hard";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        s = br.readLine().trim();
        cost = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cost[i] = Long.parseLong(st.nextToken());

        // init memo with -1 meaning "not computed"
        memo = new long[n][4];
        for (int i = 0; i < n; i++) Arrays.fill(memo[i], -1L);

        long ans = dfs(0, 0);
        System.out.println(ans);
    }

    // returns minimum cost for suffix starting at i, having kept j chars of "hard" so far
    static long dfs(int i, int j) {
        if (j >= 4) {
            // forbidden: we already formed "hard"
            return INF;
        }
        if (i == n) {
            // no more characters, cost 0
            return 0L;
        }
        if (memo[i][j] != -1L) return memo[i][j];

        char ch = s.charAt(i);
        long ans = INF;

        if (ch == HARD.charAt(j)) {
            // Option 1: delete s[i]
            long deleteCost = cost[i] + dfs(i + 1, j);
            ans = Math.min(ans, deleteCost);

            // Option 2: keep s[i] and advance to j+1 if that doesn't complete "hard"
            if (j + 1 < 4) {
                long keepCost = dfs(i + 1, j + 1);
                ans = Math.min(ans, keepCost);
            } else {
                // j+1 == 4 means keeping makes full "hard" -> disallowed (INF)
            }
        } else {
            // character doesn't match current needed char of "hard" -> just keep it
            ans = Math.min(ans, dfs(i + 1, j));
        }

        memo[i][j] = ans;
        return ans;
    }
}
