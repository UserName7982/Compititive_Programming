package BiinarySearch;
import java.util.*;

public class ExamSelection {
    static class Task {
        int t, a, idx;
        Task(int t, int a, int idx) {
            this.t = t;
            this.a = a;
            this.idx = idx;
        }
    }

    static int n, T;
    static Task[] tasks;

    // Return list of indices of feasible tasks for given k, or null if not possible
    static List<Integer> check(int k) {
        List<Task> eligible = new ArrayList<>();
        for (Task task : tasks) {
            if (task.a >= k) eligible.add(task);
        }

        if (eligible.size() < k) return null; // not enough tasks with a >= k

        eligible.sort(Comparator.comparingInt(t -> t.t)); // pick smallest t first

        long total = 0;
        List<Integer> selected = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            total += eligible.get(i).t;
            if (total > T) return null;
            selected.add(eligible.get(i).idx);
        }

        return selected;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        T = sc.nextInt();
        tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            tasks[i] = new Task(t, a, i + 1);
        }

        int lo = 0, hi = n;
        int bestK = 0;
        List<Integer> best = new ArrayList<>();

        // Binary search for maximum feasible k
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            List<Integer> res = check(mid);
            if (res != null) {
                bestK = mid;
                best = res;
                lo = mid + 1; // try bigger
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(bestK);
        System.out.println(best.size());
        for (int i = 0; i < best.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(best.get(i));
        }
        System.out.println();
        sc.close();
    }
}
