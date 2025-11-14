package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bipartite {
      public static boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) { // unvisited node
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                color[start] = 0; // start coloring with 0

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : graph.get(node)) {
                        if (color[neighbor] == -1) {
                            // Assign opposite color
                            color[neighbor] = 1 - color[node];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            // Same color on both ends → not bipartite
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
        // Graph represented as adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Example: 0-1, 0-3, 2-1, 2-3 (a square — bipartite)
        for (int i = 0; i < 4; i++) graph.add(new ArrayList<>());

        graph.get(0).add(1);
        graph.get(0).add(3);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(3).add(0);
        graph.get(3).add(2);

        System.out.println(isBipartite(graph) ? "Graph is Bipartite" : "Graph is NOT Bipartite");
    }
}
