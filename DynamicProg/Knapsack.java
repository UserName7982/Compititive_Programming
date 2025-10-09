package DynamicProg;

public class Knapsack {
    public static int knapsack(int wt[], int val2[], int val, int i, int[][] dp) {
        if (val == 0) {
            return 0; 
        }
        if (i < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][val] != -1) {
            return dp[i][val];
        }

        int ans = knapsack(wt, val2, val, i - 1, dp); 
        if (val - val2[i] >= 0) {
            int sub = knapsack(wt, val2, val - val2[i], i - 1, dp);
            if (sub != Integer.MAX_VALUE) { 
                ans = Math.min(ans, sub + wt[i]);
            }
        }

        return dp[i][val] = ans;
    }

    public static void main(String[] args) {
        int wt[] = { 3,3,4,5 };
        int val[] = { 8,30,50,60 };
        int W = 8;
        int n = wt.length;
        int dp[][] = new int[n][10011];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10010; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = 0;
        for (int i = 10010; i >= 0; i--) {
            if (knapsack(wt, val, i, n - 1, dp) <= W) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
