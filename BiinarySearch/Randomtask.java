package BiinarySearch;
import java.util.Scanner;

public class Randomtask {

    static long[][] dp = new long[65][65];

    public static void combinatrics() {
        for (int i = 0; i <= 64; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    }

    public static long get(long n, int k) {
        if (n == 0) return 0;
        int rem = k;
        long ans = 0;

        for (int bit = 63; bit >= 0; bit--) {
            if (((n >>> bit) & 1L) == 1L) {
                if (rem >= 0 && rem <= bit && bit < dp.length) {
                    ans += dp[bit][rem];
                }
                rem--;
                if (rem < 0) break;
            }
        }
        if (rem == 0) ans++;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        int k = sc.nextInt();
        sc.close();

        combinatrics();

        long low = 0L;
        long high = (long) 1_000_000_000_000_000_000L; 

        while (low + 1 < high) {
            long mid = (low + high) >>> 1;

            long twoMid;
            if (mid > Long.MAX_VALUE / 2) twoMid = Long.MAX_VALUE;
            else twoMid = mid * 2L;

            long cnt = get(twoMid, k) - get(mid, k);

            if (cnt < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(high);
    }
}
