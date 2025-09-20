package Graph;

import java.util.*;

public class LCA {
    HashMap<Integer, List<Integer>> tree = new HashMap<>();
    Map<Integer, Integer> parent;

    public int lca(int x, int y) {
        parent = new HashMap<>();
        dfs(1, -1);  // assuming 1 is the root

        List<Integer> p1 = getPath(x);
        List<Integer> p2 = getPath(y);

        int lca = -1;
        int i = 0, j = 0;
        while (i < p1.size() && j < p2.size()) {
            if (!p1.get(i).equals(p2.get(j))) break;
            lca = p1.get(i);
            i++;
            j++;
        }
        return lca;
    }

    private void dfs(int node, int par) {
        parent.put(node, par);
        if (!tree.containsKey(node)) return;  // safety check
        for (int child : tree.get(node)) {
            if (child != par) {
                dfs(child, node);
            }
        }
    }

    private List<Integer> getPath(int node) {
        List<Integer> path = new ArrayList<>();
        while (node != -1) {
            path.add(0, node); // add at beginning so it's root → node
            node = parent.get(node);
        }
        return path;
    }
}
