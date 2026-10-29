import java.util.*;

class Solution {
    private List<List<Integer>> adj;
    private int[] depth, parent, tin, tout;
    private int timer = 0;
    private char[] sChars;
    private int LOG;
    private int[][] up; // Binary lifting for LCA
    private FenwickTree bit;

    // Fixed method name to match the Driver expectation
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        sChars = s.toCharArray();
        depth = new int[n];
        parent = new int[n];
        tin = new int[n];
        tout = new int[n];

        LOG = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[n][LOG];

        bit = new FenwickTree(n + 2); 

        dfsLCA(0, -1, 0);

        for (int i = 0; i < n; i++) {
            bit.rangeUpdate(tin[i], tout[i], 1 << (sChars[i] - 'a'));
        }

        List<Boolean> ansList = new ArrayList<>();
        
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                
                char oldChar = sChars[u];
                if (oldChar != c) {
                    sChars[u] = c;
                    int diffMask = (1 << (oldChar - 'a')) ^ (1 << (c - 'a'));
                    bit.rangeUpdate(tin[u], tout[u], diffMask);
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v);
                
                int maskU = bit.query(tin[u]);
                int maskV = bit.query(tin[v]);
                
                int pathMask = maskU ^ maskV ^ (1 << (sChars[lca] - 'a'));
                
                ansList.add(Integer.bitCount(pathMask) <= 1);
            }
        }

        return ansList;
    }

    private void dfsLCA(int u, int p, int d) {
        parent[u] = p;
        depth[u] = d;
        tin[u] = ++timer;

        up[u][0] = p != -1 ? p : u;
        for (int i = 1; i < LOG; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }

        for (int v : adj.get(u)) {
            if (v != p) {
                dfsLCA(v, u, d + 1);
            }
        }
        tout[u] = timer;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u; u = v; v = t;
        }
        for (int i = LOG - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }
        if (u == v) return u;
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        return parent[u];
    }

    class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int n) {
            size = n;
            tree = new int[n + 2];
        }

        void add(int i, int delta) {
            for (; i <= size; i += i & -i) {
                tree[i] ^= delta;
            }
        }

        void rangeUpdate(int l, int r, int delta) {
            add(l, delta);
            add(r + 1, delta);
        }

        int query(int i) {
            int maskSum = 0;
            for (; i > 0; i -= i & -i) {
                maskSum ^= tree[i];
            }
            return maskSum;
        }
    }
}
