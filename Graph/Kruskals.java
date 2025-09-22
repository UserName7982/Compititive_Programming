package Graph;

import java.util.Arrays;
import java.util.HashSet;

public class Kruskals {

    public int kruskals(int graph[][]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            set.add(graph[i][0]);
            set.add(graph[i][1]);
        }
        Arrays.sort(graph, (a, b) -> {
            return a[2] - b[2];
        });
        int n = set.size();
        DSU dsu = new DSU(n);
        int ans = 0;
        for (int i = 0; i < graph.length; i++) {
            int v = graph[i][1], u = graph[i][0];
            int wt = graph[i][2];
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                ans += wt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Kruskals obj = new Kruskals();
        int graph[][] = { { 5, 4, 9 }, { 1, 4, 1 }, { 5, 1, 4 }, { 4, 3, 5 }, { 4, 2, 3 }, { 3, 2, 3 }, { 2, 6, 7 },
                { 1, 2, 2 }, { 3, 6, 8 } };
        System.out.println(obj.kruskals(graph));
    }
}
