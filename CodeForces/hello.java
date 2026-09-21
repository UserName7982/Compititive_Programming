package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hello {

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
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            int L = -1, R = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] != 0) {
                    L = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    R = i;
                    break;
                }
            }

            if (L != -1) {
                arr[L] = 1;
                arr[R] = 1;
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] == -1)
                    arr[i] = 0;
            }

            for (int k = 0; k < n; k++)
                sb.append(arr[k]).append(' ');
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
