package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minus_Two {

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
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        while (t-- > 0) {
            
            int n = sc.nextInt();
            int[] arr = new int[n];
            int countodd = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] % 2 != 0)
                    countodd++;
            }

            int count0 = 0;
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    if ((arr[i] / 2) % 2 == 0) {
                        count0++;
                    } else
                        count1++;
                }
            }

            int ans = Math.max(countodd, Math.max(count0, count1));
            System.out.println(ans);

        }
    }
}
