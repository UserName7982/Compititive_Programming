
import java.util.Scanner;

public class Scuza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            long[] arr = new long[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextLong();
            }

            long[] arrk = new long[k];
            for (int i = 0; i < k; i++) {
                arrk[i] = sc.nextLong();
            }

            long[] prefix = new long[n];
            prefix[0] = arr[0];
            for (int i = 1; i < n; i++) {
                prefix[i] = arr[i] + prefix[i - 1];
            }
            long[] max = new long[n];
            max[0] = arr[0];
            for (int i = 1; i < n; i++) {
                max[i] = Math.max(max[i - 1], arr[i]);
            }
            for (int i = 0; i < k; i++) {
                long space = arrk[i];
                int need = upper(space, max);
                if (need == n) {
                    System.out.print(prefix[n - 1] + " ");
                } else {
                    if ((need - 1 < 0)) {
                        System.out.print(0 + " ");
                    } else {
                        System.out.print(prefix[need-1] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    static int upper(long target, long[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
