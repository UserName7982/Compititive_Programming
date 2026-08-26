package CodeForces;
import java.util.*;

public class Cysclist {
    public static long maxWinPlays(int n, int k, int p, long m, int[] a) {
        int idx = p - 1;        
        long winCost = a[idx];

        if (n == 1) {
            return m / winCost;
        }

    
        long init = 0;
        if (p > k) {
            long prefixSum = 0;
            PriorityQueue<Integer> heap = new PriorityQueue<>(); 

            for (int i = 0; i < p - 1; i++) {
                prefixSum += a[i];

                if (k - 1 > 0) {
                    heap.offer(a[i]);
                    if (heap.size() > k - 1) heap.poll();
                }
            }

            long largestKeep = 0;
            while (!heap.isEmpty()) largestKeep += heap.poll();

            init = prefixSum - largestKeep;
        }

     
        long othersSum = 0;
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(); // keep largest (k-1)

        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            othersSum += a[i];

            if (k - 1 > 0) {
                heap2.offer(a[i]);
                if (heap2.size() > k - 1) heap2.poll();
            }
        }

        long largestKeepCycle = 0;
        while (!heap2.isEmpty()) largestKeepCycle += heap2.poll();

        long cycle = othersSum - largestKeepCycle;

        long low = 0, high = m / Math.max(1L, winCost) + 1;

        while (low < high) {
            long mid = (low + high + 1) / 2;

            long total;
            if (mid == 0) {
                total = 0;
            } else {
                total = init + mid * winCost + (mid - 1) * cycle;
            }

            if (total <= m) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            long m = sc.nextLong();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        System.out.println(maxWinPlays(n, k, p, m, a));
    }
}
}