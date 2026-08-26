import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException { return Integer.parseInt(next()); }
    public long nextLong() throws IOException { return Long.parseLong(next()); }
    public double nextDouble() throws IOException { return Double.parseDouble(next()); }
    public String nextLine() throws IOException { return br.readLine(); }
}