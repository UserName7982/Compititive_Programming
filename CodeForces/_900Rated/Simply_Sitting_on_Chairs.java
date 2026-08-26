package CodeForces._900Rated;
import java.util.*;

public class Simply_Sitting_on_Chairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int minP = Integer.MAX_VALUE;
            int ans = 0;

            for (int i = 0; i < n; i++) {
                minP = Math.min(minP, p[i]);

                if (minP >= i + 1) {
                    ans++;
                } else {
                    break;
                }
            }

            System.out.println(ans);
        }
    }
}