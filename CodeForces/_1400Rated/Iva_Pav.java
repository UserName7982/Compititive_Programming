package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Iva_Pav {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                queries[i][0] = Integer.parseInt(st.nextToken()); // l (1-indexed)
                queries[i][1] = Integer.parseInt(st.nextToken()); // k
            }

            int LOG = 1;
            while ((1 << LOG) <= n) LOG++;

            int[] log = new int[n + 1];
            for (int i = 2; i <= n; i++) log[i] = log[i / 2] + 1;

            int[][] sparse = new int[LOG][n];
            for (int i = 0; i < n; i++) sparse[0][i] = arr[i];

            for (int i = 1; i < LOG; i++) {
                int half = 1 << (i - 1);
                int len = 1 << i;
                for (int j = 0; j + len - 1 < n; j++) {
                    sparse[i][j] = sparse[i - 1][j] & sparse[i - 1][j + half];
                }
            }

            for (int[] qu : queries) {
                int l = qu[0] - 1; // convert to 0-indexed
                int k = qu[1];

                if (arr[l] < k) {
                    sb.append(-1+" ");
                    continue;
                }
                int r = binary(sparse, l, n, log, k);
                sb.append((r + 1)+" "); // convert back to 1-indexed for output
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int binary(int[][] sparse, int l, int n, int[] log, int k) {
        int ans = l;
        int low = l, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int len = mid - l + 1;
            int level = log[len];
            int val = sparse[level][l] & sparse[level][mid - (1 << level) + 1];
            if (val >= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}