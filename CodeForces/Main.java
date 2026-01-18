package CodeForces;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long s = sc.nextLong();
            long k = sc.nextLong();
            long m = sc.nextLong();

            long ans;
            if (m < k) {
                ans = Math.max(0L, s - m);
            } else {
                ans = Math.max(0L, Math.min(s, k) - (m % k));
            }

            System.out.println(ans);
        }
    }
}
