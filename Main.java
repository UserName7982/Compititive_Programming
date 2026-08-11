import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine().trim());
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                int ans = arr[i];
                for (int j = i; j < arr.length; j++) {
                    ans = Math.max(ans, getMex(i, j, arr) + dp[j + 1]);
                }
                dp[i] = ans;
            }
            sb.append(dp[0]).append('\n');
        }
        System.out.print(sb);
    }

    static int getMex(int i, int j, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int k = i; k <= j; k++) {
            set.add(arr[k]);
        }
        for (int m = 0; m <= j - i + 1; m++) {
            if (!set.contains(m)) {
                return m;
            }
        }
        return 0;
    }
}