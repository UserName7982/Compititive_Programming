package CodeForces.Contest_DIV_2;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Village_Guilds
 * During his long adventure, Steve stumbled upon a village of villagers. The
 * houses in the village are connected by bidirectional paths. In total, there
 * are n
 * houses in the village, numbered from 1
 * to n
 * . The graph of houses and paths represents a rooted∗
 * tree†
 * , rooted at vertex 1
 * , where the town hall is located.
 * 
 * Consider an arbitrary house v
 * and its subtree‡
 * . For each such house v
 * and each non-negative integer h
 * , consider the set of houses that are in the subtree of v
 * at a distance exactly h
 * from v
 * . Such a set will be called a guild. For example, for h=0
 * , the guild will consist only of the vertex v
 * .
 * 
 * In the example below, the guilds for the vertex v=4
 * are shown. The guild for h=0
 * is marked in red, for h=1
 * in light blue, and for h=2
 * in green.
 * 
 * Two guilds are considered different if there exists a house that is in one
 * guild and not in the other. Steve wants to know how many different non-empty
 * guilds there are in the tree. Help him with this.
 * 
 * ∗
 * A rooted tree is a tree where one vertex is special and called the root.
 * 
 * †
 * A tree is a connected graph without cycles.
 * 
 * ‡
 * A subtree of vertex v
 * is the subgraph of v
 * , all its descendants, and all the edges between them.
 * 
 * Input
 * Each test contains multiple test cases. The first line contains the number of
 * test cases t
 * (1≤t≤104
 * ). The description of the test cases follows.
 * 
 * The first line of each test case contains a single integer n
 * (2≤n≤2⋅105
 * ) — the number of houses in the village.
 * 
 * The second line contains n−1
 * integers p2,p3,…,pn
 * (1≤pi<i
 * ), where pi
 * is the parent of the i
 * -th house in the tree.
 * 
 * It is guaranteed that the sum of n
 * over all test cases does not exceed 2⋅105
 * .
 * 
 * Output
 * For each test case, output a single integer — the number of different guilds
 * in the village.
 */
public class Village_Guilds {

    public static void dfs(
            int node,
            HashMap<Integer, List<Integer>> map,
            int[] sec_max_depth,
            int[] max_depth) {

        max_depth[node] = 1;
        sec_max_depth[node] = 0;

        if (!map.containsKey(node))
            return;

        for (int child : map.get(node)) {
            dfs(child, map, sec_max_depth, max_depth);

            int depth = max_depth[child] + 1;

            if (depth > max_depth[node]) {
                sec_max_depth[node] = max_depth[node];
                max_depth[node] = depth;
            } else if (depth > sec_max_depth[node]) {
                sec_max_depth[node] = depth;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n + 1];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 2; i <= n; i++) {
                p[i] = sc.nextInt();
                map.putIfAbsent(p[i], new java.util.ArrayList<>());
                map.get(p[i]).add(i);
            }
            int[] sec_max_depth = new int[n + 1];
            int[] max_depth = new int[n + 1];
            dfs(1, map, sec_max_depth, max_depth);
            int ans = 0;
            for(int num: sec_max_depth){
                if(num==0) ans+=1;
                else ans+=num;
            }
            System.out.println(ans-1);
        }
    }
}