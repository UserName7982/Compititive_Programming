package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class min_swap {

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
    public static void main(String[] args) throws IOException{
        FastScanner fs = new FastScanner();
        int t=fs.nextInt();

        while(t-->0){
            int n=fs.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=fs.nextInt();
            }

            int left=0;
            int right=n-1;

            while(left<n && arr[left]==1){
                left++;
            }

            while(right>=0 && arr[right]==1){
                right--;
            }
            int ans=0;
            if(left>=right){
                ans=-1;
            } else {
                if(right<n-1){
                    ans++;
                }
                if(left>0){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
