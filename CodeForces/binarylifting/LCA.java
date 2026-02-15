package CodeForces.binarylifting;

public class LCA {
    BinaryLifting bl;
    public int lca(int numNodes,int a,int b) {
        bl = new BinaryLifting();
        bl.AnschestoryNode(numNodes);
        
        if (bl.depth[a]<bl.depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int k=bl.depth[a]-bl.depth[b];
        for(int j=1; j<bl.LOG; j++) {
            if ((k & (1 << j)) > 0) {
                a = bl.up[a][j];
            }
        }

        if (a==b) {
            return a;
        }
        // To find LCA of a and b
        for(int j = bl.LOG - 1; j >= 0; j--) {
            if (bl.up[a][j] != bl.up[b][j]) {
                a = bl.up[a][j];
                b = bl.up[b][j];
            }
        }
        return bl.up[a][0];
    }
}
