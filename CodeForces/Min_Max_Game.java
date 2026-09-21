package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min_Max_Game {

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
        FastScanner fs=new FastScanner();
        int t=fs.nextInt();
        while (t-->0) {
            int n=fs.nextInt();
            int[] arr=new int[n];
            
            int count0=0;
            int count1=0;
            for (int i = 0; i < arr.length; i++) {
                arr[i]=fs.nextInt();
                if (arr[i]==1) {
                    count1++;
                }else{
                    count0++;
                }
            }
            if(count0>count1){
                System.out.println("Elsie");
            }else{
                System.out.println("Bessie");
            }

        }
    }
}
