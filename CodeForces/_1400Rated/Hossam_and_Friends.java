package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Hossam_and_Friends {

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
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Map<Integer, TreeSet<Integer>> map = new HashMap<>();
            for (int e = 0; e < m; e++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                map.putIfAbsent(u, new TreeSet<>());
                map.putIfAbsent(v, new TreeSet<>());
                map.get(u).add(v);
                map.get(v).add(u);
            }

            int i = 1;
            long ans = 0;
            for (int j = 1; j <= n; j++) {
                TreeSet<Integer> neighbors = map.get(j);
                if (neighbors != null) {
                    // greatest neighbor strictly less than j (i.e. inside [1, j-1])
                    Integer maxU = neighbors.lower(j);
                    if (maxU != null && maxU >= i) {
                        i = maxU + 1;
                    }
                }
                ans += (j - i + 1);
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}