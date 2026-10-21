package CodeForces._1500Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K_Complete_Word {
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

        while(t-->0){
            int n=fs.nextInt();
            int k=fs.nextInt();
            String s=fs.next();
            int grpsize=(k+1)/2;
            int[][] g=new int[grpsize][26];
            for(int i=0;i<n;i++){
                int j=i%k;
                if(k>=k/2){
                    j=Math.min(j,k-1-j);
                }
                g[j][s.charAt(i)-'a']++;
            }
            int ans=0;
            for(int i=0;i<grpsize;i++){
                int max=0;
                int sum=0;
                for(int j=0;j<26;j++){
                    max=Math.max(max,g[i][j]);
                    sum+=g[i][j];
                }
                ans+=sum-max;
            }
            System.out.println(ans);
        }
    }
}
