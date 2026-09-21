package CodeForces._1400Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import CodeForces.XOR;

public class Maximize_XOR {
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

    //a + b = (a XOR b) + 2*(a AND b).
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();

        while (t-- > 0) {
            long x = fs.nextLong();
            long y = fs.nextLong();
            long MAX_XOR = y + x;

            int MSB = 63 - Long.numberOfLeadingZeros(MAX_XOR);
            long num1 = 0;
            for (int i = MSB; i >= 0; i--) {
                int want = ((MAX_XOR >> i) & 1) != 0 ? 1 : 0;
                if (want == 1) {
                    if ((num1 | (1 << i)) > x) {
                    } else {
                        num1 |= (1 << i);
                    }
                }
            }
            System.out.println(MAX_XOR + " " + (x - num1));
        }
    }
}
