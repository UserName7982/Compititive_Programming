package CodeForces;
import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] a = new int[n + 1];

            for (int k = 1; k <= n; k++) {
                a[k] = fs.nextInt();
            }

            int[] diff = new int[n + 1];

            for (int k = 1; k <= n; k++) {

                long m = a[k];

                long L = k * m;
                long R = k * (m + 1) - 1;

                if (L >= n) {
                    continue;
                }

                R = Math.min(R, n - 1);

                diff[(int) L]++;

                if (R + 1 < n) {
                    diff[(int) R + 1]--;
                }
            }

            List<Integer> B = new ArrayList<>();

            int forbidden = 0;

            for (int x = 0; x < n; x++) {

                forbidden += diff[x];

                if (forbidden == 0) {
                    B.add(x);
                }
            }

            out.append(B.size()).append('\n');

            for (int x : B) {
                out.append(x).append(' ');
            }

            out.append('\n');
        }

        System.out.print(out);
    }
}