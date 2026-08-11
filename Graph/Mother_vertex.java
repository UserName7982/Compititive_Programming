package Graph;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class MotherVertex {
	public int findMotherVertex(int V, int[][] edges) {
		// code here kosaraju's algorithm
		boolean[] vis = new boolean[V];
		Stack<Integer> st = new Stack();
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for (int[] node: edges) {
			map.putIfAbsent(node[0], new ArrayList<>());
			map.get(node[0]).add(node[1]);
		}
		
		for (int i = 0; i<V; i++) {
			if (!vis[i]) {
				dfs(i, vis, st, map);
			}
		}
		
		map.clear();
		for (int[] node: edges) {
			map.putIfAbsent(node[1], new ArrayList<>());
			map.get(node[1]).add(node[0]);
		}
		
		vis = new boolean[V];
		List<List<Integer>> scc = new ArrayList<>();
		int mothervertex = st.peek();
		
		while (!st.isEmpty()) {
			int node = st.pop();
			if (!vis[node]) {
				List<Integer> ls = new ArrayList<>();
				dfs1(node, vis, map, ls);
				scc.add(ls);
			}
		}
		
		map.clear();
		for (int[] node: edges) {
			map.putIfAbsent(node[0], new ArrayList<>());
			map.get(node[0]).add(node[1]);
		}
		
		vis = new boolean[V];
		check(mothervertex, vis, map);
		
		for (int i = 0; i<V; i++) {
			if (!vis[i])
				return - 1;
		}
		
		int ans = Integer.MAX_VALUE;
		
		for (List<Integer> sc : scc) {
			if (sc.contains(mothervertex)) {
				for (int v : sc) {
					ans = Math.min(ans, v);
				}
				break;
			}
		}
		
		return ans;
	}
	
	void dfs(int node, boolean[] vis, Stack<Integer> st, Map<Integer, List<Integer>> map) {
		vis[node] = true;
		List<Integer> ls = map.getOrDefault(node, new ArrayList<>());
		
		for (int nei: ls) {
			if (!vis[nei]) {
				dfs(nei, vis, st, map);
			}
		}
		st.push(node);
	}
	
	void dfs1(int node, boolean[] vis, Map<Integer, List<Integer>> map, List<Integer> scc) {
		vis[node] = true;
		scc.add(node);
		List<Integer> ls = map.getOrDefault(node, new ArrayList<>());
		for (int nei: ls) {
			if (!vis[nei]) {
				dfs1(nei, vis, map, scc);
			}
		}
	}
	
	void check(int node, boolean[] vis, Map<Integer, List<Integer>> map) {
		vis[node] = true;
		List<Integer> ls = map.getOrDefault(node, new ArrayList<>());
		for (int nei: ls) {
			if (!vis[nei]) {
				check(nei, vis, map);
			}
		}
	}
}
