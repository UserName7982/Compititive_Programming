package CodeForces;
import java.io.*;
import java.util.*;

public class cherry {

    static ArrayList<Integer>[] tree;
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            tree = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                String[] parts = br.readLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                tree[u].add(v);
                tree[v].add(u);
            }

            dp = new boolean[n + 1][3];

            dfs(1, 0);

            out.append(dp[1][0] ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }

    static void dfs(int v, int parent) {
        boolean isLeaf = true;

        // Start with sum = 0 for "do not shake v"
        boolean[] ways = new boolean[3];
        ways[0] = true;

        for (int child : tree[v]) {
            if (child == parent) continue;
            isLeaf = false;

            dfs(child, v);

            boolean[] newWays = new boolean[3];

            for (int a = 0; a < 3; a++) {
                if (!ways[a]) continue;
                for (int b = 0; b < 3; b++) {
                    if (dp[child][b]) {
                        newWays[(a + b) % 3] = true;
                    }
                }
            }

            ways = newWays;
        }

        if (isLeaf) {
            // Leaf: must shake itself
            dp[v][1] = true;
            return;
        }

        // Option 1: don't shake v
        for (int r = 0; r < 3; r++) {
            dp[v][r] = ways[r];
        }

        // Option 2: shake v
        dp[v][1] = true;
    }
}
