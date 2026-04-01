class Solution {

    public class DSU {

        private int[] parent;
        private int[] size;
        private int[] weights;

        public DSU(int n) {
            parent = new int[n];
            weights = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int v) {
            if (parent[v] != v) {
                int originalparent=parent[v];
                parent[v] = find(parent[v]); 
                weights[v]+=weights[originalparent];
            }
            return parent[v];
        }

        public boolean union(int u, int v,int w) {
            int a = find(u);
            int b = find(v);
            if (a == b) {
                return false;
            }
            if (a != b) {
                if (size[a] < size[b]) {
                    parent[a] = b;
                    size[b] += size[a];
                    weights[a]=weights[v]-weights[u]+w;
                } else {
                    parent[b] = a;
                    size[a] += size[b];
                    weights[b]=weights[v]-weights[u]+w;
                }
                
            }
            return true;
        }
    }

    public int numberOfEdgesAdded(int n, int[][] edges) {
        int ans=0;
        DSU dsu=new DSU(n);
        for(int[] edge: edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            if(dsu.find(u)!=dsu.find(v)){
                dsu.union(u,v,w);
                ans++;
            }else{
                if((dsu.weights[u]+dsu.weights[v]+w)%2==0){
                    ans++;
                    dsu.union(u,v,w);
                }
            }
        }
        return ans;
    }
}