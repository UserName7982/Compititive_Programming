package Graph;

public class DSU {
    
    public int[] parent;
    public int[] size;

    public void make(int v){
        parent[v]=v;
        size[v]=1;
    }

    public int find(int v){
        if (parent[v]==v) {
            return v;
        }
        return parent[v]=find(v);
    }

    public void union(int u,int v){
        int a=find(u);
        int b=find(v);

        if(size[a]<size[b]){
            parent[a]=b;
            size[a]+=b;
        }else{
            parent[b]=a;
            size[b]+=a;
        }
    }
}
