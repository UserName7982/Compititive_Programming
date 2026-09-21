package CodeForces._1500Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AGAGA_XOOORRR {

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
        FastScanner fs=new FastScanner();

        int t=fs.nextInt();
        while (t-->0) {
            int n=fs.nextInt();
            long[] arr=new long[n];

            for (int i = 0; i < n; i++) {
                arr[i]=fs.nextLong();
            }

            // long[] prefix=new long[n+1];
            // long[] suffix=new long[n+1];

            // for (int i = 1; i <= n; i++) {
            //     prefix[i]^=arr[i-1];
            // }
            // for (int i = n-1; i>=0; i--) {
            //     suffix[i]^=arr[i];
            // }

            
            long xor=0;
            for (int i = 0; i < n; i++) {
                xor^=arr[i];
            }
            if(xor==0){
                System.out.println("YES");
            }else{
                int l=-1;
                int r=n;
                long xor1=0;
                for(int i=0; i<n; i++){
                    xor1^=arr[i];
                    if(xor1==xor){
                        l=i;
                        break;
                    }
                }
                long xor2=0;
                for(int i=n-1; i>=0; i--){
                    xor2^=arr[i];
                    if(xor2==xor){
                        r=i;
                        break;
                    }
                }
                if(l<r){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
