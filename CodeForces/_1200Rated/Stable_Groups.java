package CodeForces._1200Rated;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Stable_Groups {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        long k = Long.parseLong(st1.nextToken());
        long x = Long.parseLong(st1.nextToken());

        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        // collect the "cost to bridge" for every gap that currently exceeds x
        List<Long> costs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            long gap = arr[i] - arr[i - 1];
            if (gap > x) {
                // number of extra students needed to make this gap stable
                long cost = (gap + x - 1) / x - 1; // ceil(gap/x) - 1
                costs.add(cost);
            }
        }

        long groups = costs.size() + 1; // start: one group per "broken" segment
        Collections.sort(costs); // cheapest merges first

        for (long cost : costs) {
            if (k >= cost) {
                k -= cost;
                groups--; // successfully bridged this gap, merging two groups into one
            } else {
                break; // costs are sorted ascending; can't afford this or any pricier one
            }
        }

        System.out.println(groups);
    }
}