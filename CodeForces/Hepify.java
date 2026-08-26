package CodeForces;
import java.util.*;

public class Hepify {

    static class DSU {
        int[] p, sz;
        DSU(int n) {
            p = new int[n + 1];
            sz = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = i;
                sz[i] = 1;
            }
        }
        int find(int x) {
            if (p[x] == x) return x;
            return p[x] = find(p[x]);
        }
        void union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return;
            if (sz[a] < sz[b]) { int t = a; a = b; b = t; }
            p[b] = a;
            sz[a] += sz[b];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) a[i] = sc.nextInt();

            DSU dsu = new DSU(n);

            for (int i = 1; i <= n / 2; i++) {
                dsu.union(i, 2 * i);
            }

            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (dsu.find(i) != dsu.find(a[i])) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }
    }
}
