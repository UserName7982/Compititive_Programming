package Graph;

import java.util.*;

public class Dijkstra {
    public int dijkstra(Map<Integer, List<int[]>> graph, int source, int destination) {
        int n = graph.size();
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int d = node[1];

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] edge : graph.getOrDefault(u, Collections.emptyList())) {
                int v = edge[0], weight = edge[1];
                if (d + weight < dist[v]) {
                    dist[v] = d + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist[destination];
    }
}
