package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class tarjan {
	int timer = 0;
	public boolean isBridge(int V, int[][] edges, int c, int d) {
		// code here
		Set<String> set = new HashSet<>();
		boolean[] vis = new boolean[V];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] num: edges) {
			map.putIfAbsent(num[0], new ArrayList<>());
			map.putIfAbsent(num[1], new ArrayList<>());
			map.get(num[0]).add(num[1]);
			map.get(num[1]).add(num[0]);
		}
		int[] tin = new int[V];
		int[] low = new int[V];
		for (int i = 0; i<V; i++) {
			if (!vis[i]) {
				dfs(i,-1, tin, low, vis, set, map);
			}
		}
		String key = "" + c+"," + d;
		return (set.contains(key));
	}
	
	public void dfs(int node,int parent, int[] tin, int[] low, boolean[] vis, Set<String> set, Map<Integer, List<Integer>> map) {
		vis[node] = true;
		tin[node] = low[node] = timer++;
		for (int v : map.getOrDefault(node, new ArrayList<>())) {
		    if(v==parent) continue;
			if (!vis[v]) {
				dfs(v,node, tin, low, vis, set, map);
				low[node] = Math.min(low[node], low[v]);
				if (low[v]>tin[node]) {
					String key = "" + node + "," + v;
					String key1 = "" + v+"," + node;
					set.add(key);
					set.add(key1);
				}
			} else {
				low[node] = Math.min(low[node], low[v]);
			}
		}
	}
}