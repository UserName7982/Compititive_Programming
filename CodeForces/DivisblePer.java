package CodeForces;
import java.util.*;

public class DivisblePer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) set.add(i);

            int[] arr = new int[n + 1];

            arr[n] = 1;
            set.remove(1);

            for (int i = n - 1; i >= 1; i--) {
                boolean found = false;

                Iterator<Integer> it = set.iterator(); 
                while (it.hasNext()) {
                    int val = it.next();
                    if (Math.abs(arr[i + 1] - val) % i == 0) {
                        arr[i] = val;
                        it.remove();
                        found = true;
                        break;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
