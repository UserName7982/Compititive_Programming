package Graph;

import java.io.*;
import java.util.*;

public class BeautifulGraph {
    static final int MOD = 998244353;
    static long[] pow2 = new long[300001];
    static List<Integer>[] g;
    static int[] color;
    static int n, m;

    static void precompute() {
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        precompute();

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            g = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                g[u].add(v);
                g[v].add(u);
            }

            color = new int[n + 1];
            Arrays.fill(color, -1);

            long ans = 1;
            boolean ok = true;

            for (int i = 1; i <= n; i++) {
                if (color[i] == -1) {
                    int[] cnt = new int[3];
                    if (!bfs(i, cnt)) {
                        ok = false;
                        break;
                    }
                    long ways = (pow2[cnt[1]] + pow2[cnt[2]]) % MOD;
                    ans = (ans * ways) % MOD;
                }
            }

            out.append(ok ? ans : 0).append('\n');
        }

        System.out.print(out);
    }

    static boolean bfs(int start, int[] cnt) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        color[start] = 1;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            cnt[color[u]]++;
            for (int v : g[u]) {
                if (color[v] == -1) {
                    color[v] = 3 - color[u];
                    q.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    // ✅ Fast input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        
    }
}
