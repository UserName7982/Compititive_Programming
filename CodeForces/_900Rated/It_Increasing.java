package CodeForces._900Rated;
import java.util.*;

public class It_Increasing {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int ans = 0;
            boolean ok = true;

            for (int i = n - 2; i >= 0; i--) {
                while (arr[i] >= arr[i + 1] && arr[i] > 0) {
                    arr[i] /= 2;
                    ans++;
                }

                if (arr[i] >= arr[i + 1]) {
                    ok = false;
                }
            }

            System.out.println(ok ? ans : -1);
        }

        sc.close();
    }
}