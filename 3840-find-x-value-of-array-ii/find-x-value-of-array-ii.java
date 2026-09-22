import java.util.Arrays;

class Solution {
    // 1. Move fields outside of methods so they are proper class variables
    private int n;
    private int kVal;
    private int[] a;
    private Node[] tr;

    // 2. Segment Tree Node class declared properly as an inner class
    private static class Node {
        int l, r, p;
        int[] c;

        Node(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.p = 0;
            this.c = new int[k];
        }
        
        Node(int k) {
            this.c = new int[k];
        }
    }

    // 3. Helper method to merge information from child nodes into a parent node
    private void pushUp(Node u, Node left, Node right) {
        u.p = (left.p * right.p) % kVal;
        
        // Copy the ways from the left child
        for (int i = 0; i < kVal; i++) {
            u.c[i] = left.c[i];
        }
        
        // Accumulate ways that cross over from left into the right child
        for (int i = 0; i < kVal; i++) {
            if (right.c[i] > 0) {
                int targetMod = (left.p * i) % kVal;
                u.c[targetMod] += right.c[i];
            }
        }
    }

    // 4. Build the segment tree
    private void build(int u, int l, int r) {
        tr[u] = new Node(l, r, kVal);
        if (l == r) {
            tr[u].p = a[l];
            tr[u].c[a[l]] = 1;
        } else {
            int mid = (l + r) >> 1;
            build(u << 1, l, mid);
            build((u << 1) | 1, mid + 1, r);
            pushUp(tr[u], tr[u << 1], tr[(u << 1) | 1]);
        }
    }

    // 5. Update value at index x to newVal
    private void modify(int u, int x, int newVal) {
        if (tr[u].l == tr[u].r) {
            tr[u].p = newVal;
            Arrays.fill(tr[u].c, 0);
            tr[u].c[newVal] = 1;
            a[x] = newVal;
        } else {
            int mid = (tr[u].l + tr[u].r) >> 1;
            if (x <= mid) {
                modify(u << 1, x, newVal);
            } else {
                modify((u << 1) | 1, x, newVal);
            }
            pushUp(tr[u], tr[u << 1], tr[(u << 1) | 1]);
        }
    }

    // 6. Query range [l, r]
    private Node query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u];
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (r <= mid) {
            return query(u << 1, l, r);
        }
        if (l > mid) {
            return query((u << 1) | 1, l, r);
        }
        
        Node res = new Node(kVal);
        pushUp(res, query(u << 1, l, r), query((u << 1) | 1, l, r));
        return res;
    }

    // 7. Core entry method matching LeetCode signature
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.kVal = k;
        this.a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] % k;
        }
        
        this.tr = new Node[n * 4];
        build(1, 0, n - 1);
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // Fixed the 2D array syntax indices down below
            int index = queries[i][0];
            int value = queries[i][1] % k;
            int start = queries[i][2];
            int x = queries[i][3];
            
            // Perform persistent update
            modify(1, index, value);
            
            // Query range from 'start' to the end of the array
            Node queryResult = query(1, start, n - 1);
            
            // Extract answer matching target remainder x
            ans[i] = queryResult.c[x];
        }
        
        return ans;
    }
}
