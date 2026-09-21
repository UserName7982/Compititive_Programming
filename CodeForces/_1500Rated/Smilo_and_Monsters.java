package CodeForces._1500Rated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Smilo_and_Monsters {
    static long inf = (Long.MAX_VALUE / 2);

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
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            // long low = 0, high = inf;
            // long ans=0;
            // while (low <= high) {
            //     long mid = (low + high) / 2;
            //     if (can(mid, arr)) {
            //         high = mid - 1;
            //         ans =  mid;
            //     } else {
            //         low = mid+1;
            //     }
            // }
            System.out.println(can(0, arr));
        }
    }

    private static int can(long target, int[] arr) {
        int i = 0, j = arr.length - 1;
        int x = 0;
        int oper = 0;
        while (i <= j) {
            if(i==j){
                if(x>=arr[i]){
                    oper++;
                }else if(x<arr[i]/2){
                    oper+=(arr[i]/2-x+1);
                }else{
                    oper+=(arr[i]-x+1);
                }
                break;
            }
            oper += arr[i];
            x += arr[i];
            if (x >= arr[j]) {
                x -= arr[j];
                oper++;
                j--;
            }
            i++;
        }
        return oper;
    }
}
