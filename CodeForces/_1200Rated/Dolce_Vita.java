// package CodeForces._1200Rated;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dolce_Vita {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            int[] arr = new int[n];
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st1.nextToken());
            Arrays.sort(arr);

            long[] prefix = new long[n];
            prefix[0] = arr[0];
            for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + arr[i];

            long ans = 0;
            for (int i = 0; i < n; i++) {
                if (prefix[i] > x) break;          
                long days = (x - prefix[i]) / (i + 1) + 1; 
                ans += days;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}