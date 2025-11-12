package Graph;

import java.io.*;
import java.util.*;

public class ValeraAndElection {
    static class Edge {
        int to, type;
        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, t));
            graph[v].add(new Edge(u, t));
        }

        int[] parent = new int[n + 1];
        int[] edgeType = new int[n + 1];
        boolean[] hasProblem = new boolean[n + 1];
        List<Integer> order = new ArrayList<>();

        // Iterative DFS
        Stack<Integer> stack = new Stack<>();
        parent[1] = -1;
        stack.push(1);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            order.add(v);
            for (Edge e : graph[v]) {
                if (parent[e.to] == 0) {
                    parent[e.to] = v;
                    edgeType[e.to] = e.type;
                    stack.push(e.to);
                }
            }
        }

        // Build child lists (avoid O(n²))
        List<Integer>[] children = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) children[i] = new ArrayList<>();
        for (int i = 2; i <= n; i++) children[parent[i]].add(i);

        List<Integer> result = new ArrayList<>();

        // Postorder traversal (bottom-up)
        for (int i = order.size() - 1; i >= 0; i--) {
            int v = order.get(i);
            boolean childHas = false;
            for (int c : children[v]) {
                if (hasProblem[c]) {
                    childHas = true;
                    break;
                }
            }
            if (!childHas && edgeType[v] == 2) result.add(v);
            hasProblem[v] = childHas || (edgeType[v] == 2);
        }

        // Output
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int x : result) sb.append(x).append(" ");
        System.out.println(sb);
    }
}
