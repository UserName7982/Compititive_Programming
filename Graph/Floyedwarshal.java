package Graph;

import java.util.*;

class FloydWarshall {
     
    public int[][] floydWarshall(Map<Integer, List<int[]>> map) {
        int n = map.size();
        int[][] dist = new int[n][n];

        // Step 1: Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;  // distance to itself is 0
        }

        // Step 2: Fill given edges
        for (int i = 0; i < n; i++) {
            List<int[]> edges = map.getOrDefault(i, new ArrayList<>());
            for (int[] edge : edges) {
                int v = edge[0], w = edge[1];
                dist[i][v] = w; // weight from i to v
            }
        }

        // Step 3: Floyd–Warshall relaxation
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist;
    }
}
