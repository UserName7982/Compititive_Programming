package DynamicProg;
import java.util.*;

public class Boredom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int MAX = 100000;
        long[] freq = new long[MAX + 1];
        
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            freq[x]++;
            if (x > maxVal) maxVal = x;
        }
        
        long[] dp = new long[maxVal + 1];
        
        dp[0] = 0;
        if (maxVal >= 1) {
            dp[1] = freq[1] * 1L;
        }
        
        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + freq[i] * i);
        }
        sc.close();
        System.out.println(dp[maxVal]);
    }
}
