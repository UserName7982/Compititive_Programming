package CodeForces._1500Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Data_Structures_Fan {

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

        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int xor1 = 0;
            int xor0 = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            String s = sc.next();
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    xor1 ^= arr[i];
                } else {
                    xor0 ^= arr[i];
                }
            }
            int[] prefix = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefix[i] = prefix[i - 1] ^ arr[i - 1];
            }

            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                int type = sc.nextInt();
                if (type == 1) {
                    int l = sc.nextInt() - 1;
                    int r = sc.nextInt() - 1;
                    int xorlr = prefix[l] ^ prefix[r + 1];
                    xor1 ^= xorlr;
                    xor0 ^= xorlr;
                } else {
                    int g = sc.nextInt();
                    out.append(g == 0 ? xor0 : xor1).append(' ');
                }
            }
            out.append("\n");
        }
        System.out.println(out);
    }
}
