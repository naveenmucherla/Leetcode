class Solution {
    private static final int MOD = 1_000_000_007;

    // Segment Tree Node representation using flat arrays
    private long[] sumOfSquares;
    private long[] sumOfCounts;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sumOfSquares = new long[4 * n];
        sumOfCounts = new long[4 * n];
        lazy = new long[4 * n];

        // Track the last seen index of each number
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSumOfSquares = 0;
        long currentWindowSquaresSum = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int prevIdx = lastSeen.getOrDefault(val, -1);

            // Update range [prevIdx + 1, i] by adding 1
            update(1, 0, n - 1, prevIdx + 1, i, 1);

            // sumOfSquares[1] holds the sum of squares of distinct counts 
            // for all subarrays ending at index i
            currentWindowSquaresSum = sumOfSquares[1];
            totalSumOfSquares = (totalSumOfSquares + currentWindowSquaresSum) % MOD;

            lastSeen.put(val, i);
        }

        return (int) totalSumOfSquares;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0) return;

        long val = lazy[node];
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        // Apply lazy values to left child
        long leftLen = mid - start + 1;
        sumOfSquares[leftChild] = (sumOfSquares[leftChild] + 2 * val * sumOfCounts[leftChild] + val * val % MOD * leftLen) % MOD;
        sumOfCounts[leftChild] = (sumOfCounts[leftChild] + val * leftLen) % MOD;
        lazy[leftChild] = (lazy[leftChild] + val) % MOD;

        // Apply lazy values to right child
        long rightLen = end - mid;
        sumOfSquares[rightChild] = (sumOfSquares[rightChild] + 2 * val * sumOfCounts[rightChild] + val * val % MOD * rightLen) % MOD;
        sumOfCounts[rightChild] = (sumOfCounts[rightChild] + val * rightLen) % MOD;
        lazy[rightChild] = (lazy[rightChild] + val) % MOD;

        lazy[node] = 0;
    }

    private void update(int node, int start, int end, int l, int r, long val) {
        if (l <= start && end <= r) {
            long len = end - start + 1;
            sumOfSquares[node] = (sumOfSquares[node] + 2 * val * sumOfCounts[node] + val * val % MOD * len) % MOD;
            sumOfCounts[node] = (sumOfCounts[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;

        if (l <= mid) {
            update(2 * node, start, mid, l, r, val);
        }
        if (r > mid) {
            update(2 * node + 1, mid + 1, end, l, r, val);
        }

        sumOfSquares[node] = (sumOfSquares[node - node + 2 * node] + sumOfSquares[2 * node + 1]) % MOD;
        sumOfCounts[node] = (sumOfCounts[2 * node] + sumOfCounts[2 * node + 1]) % MOD;
    }
}