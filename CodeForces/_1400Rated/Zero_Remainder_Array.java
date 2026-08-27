package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Zero_Remainder_Array {
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
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = fs.nextInt();
            }
            if (k == 1) {
                sb.append(0 + "\n");
                continue;
            }
            for (int i = 0; i < arr.length; i++) {
                int key = (k - arr[i] % k) % k;
                map.put(key, map.getOrDefault(Math.abs(key), 0) + 1);
            }
            // System.out.println(map);
            long ans = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                if (key == 0)
                    continue;
                ans = Math.max(ans, key + (1L*k * (val - 1)));
            }
            if (ans == 0) {
                sb.append(0).append('\n');
            } else {
                sb.append(ans + 1).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
