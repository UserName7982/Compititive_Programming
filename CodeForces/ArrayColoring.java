package CodeForces;

import java.util.*;

public class ArrayColoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Make a sorted copy
            int[] sorted = a.clone();
            Arrays.sort(sorted);

            // Map value -> index in sorted array
            Map<Integer, Integer> rank = new HashMap<>();
            for (int i = 0; i < n; i++) {
                rank.put(sorted[i], i);
            }

            // Compute expected parity difference
            int expected = (0 % 2) ^ (rank.get(a[0]) % 2);
            boolean ok = true;

            for (int i = 1; i < n; i++) {
                int cur = (i % 2) ^ (rank.get(a[i]) % 2);
                if (cur != expected) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}
