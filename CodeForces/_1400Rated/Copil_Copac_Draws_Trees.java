package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Copil_Copac_Draws_Trees {

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
        FastScanner fc = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int t = fc.nextInt();
        while (t-- > 0) {
            int n = fc.nextInt();
            int[][] arr = new int[n-1][2];
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = fc.nextInt();
                arr[i][1] = fc.nextInt();
            }
            for (int i = 0; i < arr.length; i++) {
                map.putIfAbsent(arr[i][0], new ArrayList<>());
                map.get(arr[i][0]).add(new int[] { arr[i][1], i });
                map.putIfAbsent(arr[i][1], new ArrayList<>());
                map.get(arr[i][1]).add(new int[] { arr[i][0], i });
            }
            Queue<int[]> qu = new LinkedList<>();
            List<int[]> ls = map.get(1);
            for (int i = 0; i < map.get(1).size(); i++) {
                int[] node = ls.get(i);
                qu.add(new int[] { node[0], node[1], 1 });
            }
            int ans = 1;
            int[] vis = new int[n+1];
            vis[1] = 1;
            while (!qu.isEmpty()) {
                int[] node = qu.poll();
                int ver = node[0];
                int indx = node[1];
                int val = node[2];

                if (vis[ver] == 1)
                    continue;
                vis[ver] = 1;
                List<int[]> info = map.getOrDefault(ver, new ArrayList<>());
                for (int i = 0; i < info.size(); i++) {
                    int[] child = info.get(i);
                    if (vis[child[0]] == 0) {
                        int currval = val;
                        if (child[1] < indx) {
                            currval++;
                        }

                        qu.add(new int[] { child[0], child[1], currval });
                        ans = Math.max(ans, currval);
                    }
                }
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb.toString());
    }
}
