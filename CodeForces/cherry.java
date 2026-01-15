package CodeForces;

import java.util.ArrayList;
import java.util.Scanner;

public class cherry {
    static ArrayList<Integer>[] tree;
    static boolean[][] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while (t-->0) {
            int n=sc.nextInt();
            tree=new ArrayList[n+1];
            for (int i = 0; i <= tree.length; i++) {
                tree[i]=new ArrayList<>();
            }

            for (int i = 1; i <= n; i++) {
                int u=sc.nextInt();
                int v=sc.nextInt();
                tree[u].add(v);
                tree[v].add(u);
            }

            dp=new boolean[n+1][3];
            dfs(1,-1);
            System.out.println(dp[1][0]);
        }
    }

    static void dfs(int node, int parent){
        boolean isleaf=true;
        boolean[] ways={true,false,false};

        for(int child: tree[node]){
            isleaf=false;
            if (child==parent) {
                continue;
            }
            dfs(child, node);

            boolean[] new_ways=new boolean[3];
            for (int i = 0; i < 3; i++) {
                if (!ways[i]) {
                    continue;
                }
                for (int j = 0; j < 3; j++) {
                    if (dp[child][j]) {
                        new_ways[(j+i)%3]=true;
                    }
                }
            }
            ways=new_ways;
        }
        if (isleaf) {
            dp[node][1]=true;
            return;
        }
        for(int i=0; i<3; i++){
            dp[node][i]=ways[i];
        }
        dp[node][1]=true;
    }
}
