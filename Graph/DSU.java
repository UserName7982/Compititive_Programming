package Graph;

public class DSU {
    
    private int[] parent;
    private int[] size;
    private int components;
    public DSU(int n) {
        components = n;
        parent = new int[n+1];
        size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int v) {
        if (parent[v] != v) {
            parent[v] = find(parent[v]); // Path compression
        }
        return parent[v];
    }

    public boolean union(int u, int v) {
        int a = find(u);
        int b = find(v);
        if (a==b) {
            return false;
        }
        if (a != b) {
            if (size[a] < size[b]) {
                parent[a] = b;
                size[b] += size[a];
            } else {
                parent[b] = a;
                size[a] += size[b];
            }
        }
        components--;
        return true;
    }
}
