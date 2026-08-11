import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Articulationpoint {
    static int timer = 0;

    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        boolean[] vis = new boolean[V];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] num : edges) {
            map.putIfAbsent(num[0], new ArrayList<>());
            map.putIfAbsent(num[1], new ArrayList<>());
            map.get(num[0]).add(num[1]);
            map.get(num[1]).add(num[0]);
        }
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, tin, low, vis, isAP, map);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (isAP[i])
                ans.add(i);
        }

        if (ans.isEmpty())
            ans.add(-1);

        return ans;
    }

    public static void dfs(int node, int parent,
            int[] tin, int[] low, boolean[] vis, boolean[] isAP, Map<Integer, List<Integer>> map) {

        vis[node] = true;
        tin[node] = low[node] = timer++;

        int child = 0;

        for (int v : map.getOrDefault(node, new ArrayList<>())) {

            if (v == parent)
                continue;

            if (!vis[v]) {

                dfs(v, node, tin, low, vis, isAP, map);

                low[node] = Math.min(low[node], low[v]);

                if (parent != -1 && low[v] >= tin[node])
                    isAP[node] = true;

                child++;

            } else {

                low[node] = Math.min(low[node], tin[v]);
            }
        }

        if (parent == -1 && child > 1)
            isAP[node] = true;
    }
}
