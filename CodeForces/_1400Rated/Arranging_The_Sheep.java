package CodeForces._1400Rated;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Arranging_The_Sheep {

    static class FastScanner {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

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
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            int tot = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*')
                    tot++;
            }
            int midd = (tot + 1) / 2;
            int indx = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*')
                    count++;
                if (count == midd) {
                    break;
                }
                indx++;
            }
            int i = indx - 1;
            int j = indx + 1;
            long ans = 0;
            int countleft = 0;
            for (int k = i; k >= 0; k--) {
                if (s.charAt(k) == '*') {
                    ans += (indx - k - 1 - countleft);
                    countleft++;
                }
            }
            int countright = 0;
            for (int k = j; k < n; k++) {
                if (s.charAt(k) == '*') {
                    ans += (k - indx - 1 - countright);
                    countright++;
                }
            }
            System.out.println(ans);
        }
    }
}
