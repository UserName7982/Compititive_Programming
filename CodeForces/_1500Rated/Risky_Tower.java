package Codeforces._1500Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Risky_Tower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st0 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st0.nextToken());
            int m = Integer.parseInt(st0.nextToken());

            int[] stability = new int[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) stability[i] = Integer.parseInt(st1.nextToken());

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) grid[i][j] = Integer.parseInt(st2.nextToken());
            }
            for(int i=0; i<n; i++){
                Arrays.sort(grid[i]);
            }
            int low = 1, high = m - 1, ans = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (check(grid, stability, mid, n, m)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            sb.append(ans != -1 ? ans : m).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean check(int[][] grid, int[] stability, int mid, int n, int m) {
        PriorityQueue<Integer> st = new PriorityQueue<>();
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            int[] row = grid[i];
            for (int j = m - 1; j >= m - mid - 1; j--) {
                int val = row[j];
                if (st.size() < mid) {
                    st.offer(val);
                    sum += val;
                } else if (!st.isEmpty() && st.peek() < val) {
                    sum -= st.poll();
                    st.offer(val);
                    sum += val;
                }
            }
            if (sum >= stability[i]) return true;
        }
        return false;
    }
}