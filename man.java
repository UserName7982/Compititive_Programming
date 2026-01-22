import java.io.*;
import java.util.*;

public class man {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            if (k > n) {
                sb.append(-1).append('\n');
                continue;
            }

            if (k == n) {
                sb.append(0).append('\n');
                continue;
            }

            int answer = -1;

            // try all split depths
            for (int i = 1; i <= 31; i++) {
                long p = 1L << i;

                long low = n / p;
                long high = (n + p - 1) / p; // ceil

                if (low == k || high == k) {
                    answer = i;
                    break;
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb.toString());
    }
}
