package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Schedule_Management {

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

    public static void main(String[] args) throws IOException {
        FastScanner fc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int t = fc.nextInt();
        while (t-- > 0) {
            int n = fc.nextInt();
            int m = fc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < m; i++) {
                arr[fc.nextInt()]++;
            }
            int low = 0;
            int high = 2 * m;
            int ans = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (can(arr, mid, n, m)) {
                    high = mid - 1;
                    ans = mid;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean can(int[] arr, int t, int n, int m) {
        int complwork = 0;
        for (int i = 1; i <= n; i++) {
            complwork += Math.min(t, t + (t - arr[i]) / 2);
        }
        return complwork >= m;
    }
}
