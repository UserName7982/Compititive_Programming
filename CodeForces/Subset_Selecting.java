package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subset_Selecting {
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

        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] freq = new int[n + 2];
            for (int i = 0; i < n; i++) {
                int x = fs.nextInt();
                if (x <= n)
                    freq[x]++; 
            }
            long avail = 0;
            int ans = 0;
            for (int v = 0; v <= n; v++) {
                avail += freq[v];
                if (freq[v] == 0 || avail < k)
                    break;
                avail -= k;
                ans++;
            }
            System.out.println(ans);
        }
    }
}
