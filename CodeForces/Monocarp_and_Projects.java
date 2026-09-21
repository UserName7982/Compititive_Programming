package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Monocarp_and_Projects {

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
        int t=fs.nextInt();

        while(t-->0){
            int a=fs.nextInt();
            int b=fs.nextInt();
            long k=fs.nextLong();

            long ans=0;
            while(b/a >1 && k>0){
                ans+=(b%a);
                b++;
                a++;
                k--;
            }
            System.out.println(ans+(((k)*(b-a))));
        }
    }
}
