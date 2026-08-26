package CodeForces._1200Rated;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Same_Differences {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            HashMap<Long, Long> freq = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                long a = Long.parseLong(st.nextToken());
                long c = a - i; // key: a[i] - i
                freq.merge(c, 1L, Long::sum);
            }

            long ans = 0;
            for (long cnt : freq.values()) {
                ans += cnt * (cnt - 1) / 2;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}