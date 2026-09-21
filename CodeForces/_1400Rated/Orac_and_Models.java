package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Orac_and_Models {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            int[] dp=new int[n];
            Arrays.fill(dp, 1);
            int ans=1;
            for (int i = 0; i < arr.length; i++) {
                ans=Math.max(ans,solve(i,arr,dp));
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }

    static int solve(int i, int[] arr, int[] dp) {
        if (dp[i] != -1)
            return dp[i];
        int best = 1;
        for (int j = 2 * (i + 1) - 1; j < arr.length; j += (i + 1)) {
            if (arr[j] > arr[i]) {
                best = Math.max(best, 1 + solve(j, arr, dp));
            }
        }
        return dp[i] = best;
    }
}
