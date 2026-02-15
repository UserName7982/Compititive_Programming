package CodeForces.binarylifting;

public class BinaryLifting {
    // LCA using binary lifting
    int[][] up; // up[v][j] is the 2^j-th ancestor of v
    int LOG = 20; // maximum power of 2 less than n
    int[] depth; // depth[v] is the depth of node v
    public void AnschestoryNode(int numNodes) {
        up = new int[numNodes][LOG];
        // Initialize up[v][0] with the parent of v
        // Then fill up[v][j] for j > 0 using up[v][j-1]
        int parent[] = new int[numNodes];
        parent[0] = -1; // root has no parent
        for (int v = 1; v < numNodes; v++) {
            up[v][0] = parent[v];
        }
        depth = new int[numNodes];
        depth[0] = 0; // depth of root
        for (int v = 1; v < numNodes; v++) {
            depth[v] = depth[parent[v]] + 1;
        }
        for (int j = 1; j < LOG; j++) {
            for (int v = 0; v < numNodes; v++) {
                if (up[v][j - 1] != -1) {
                    up[v][j] = up[up[v][j - 1]][j - 1];
                } else {
                    up[v][j] = -1;
                }
            }
        }
    }
}
