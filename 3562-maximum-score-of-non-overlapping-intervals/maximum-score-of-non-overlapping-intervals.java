class Solution {
    private static class Interval {
        int left, right, weight, id;
        Interval(int left, int right, int weight, int id) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.id = id;
        }
    }

    private static class State {
        long weight;
        List<Integer> list;
        State(long weight, List<Integer> list) {
            this.weight = weight;
            this.list = list;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            arr[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        // 1. Sort intervals by their start positions
        Arrays.sort(arr, (a, b) -> Integer.compare(a.left, b.left));

        // 2. Precompute the next non-overlapping interval index via Binary Search
        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n, ans = n;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (arr[mid].left > arr[i].right) {
                    ans = mid;
                    high = mid; 
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        // 3. DP Table initialized from suffix constraints
        State[][] dp = new State[n + 1][5];
        for (int c = 0; c <= 4; c++) {
            dp[n][c] = new State(0, new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }

        // Iterate backward through the suffixes
        for (int i = n - 1; i >= 0; i--) {
            for (int c = 1; c <= 4; c++) {
                // Option 1: Skip the current interval
                State skipState = dp[i + 1][c];
                
                // Option 2: Take the current interval
                int nxt = nextIdx[i];
                long takeWeight = (long) arr[i].weight + dp[nxt][c - 1].weight;
                List<Integer> takeList = insertSorted(dp[nxt][c - 1].list, arr[i].id);

                // Choose the best option according to maximized weight and lexicographical ties
                if (isBetter(takeWeight, takeList, skipState.weight, skipState.list)) {
                    dp[i][c] = new State(takeWeight, takeList);
                } else {
                    dp[i][c] = skipState;
                }
            }
        }

        // 4. Transform tracking result back into a native integer array
        List<Integer> ansList = dp[0][4].list;
        int[] result = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            result[i] = ansList.get(i);
        }
        return result;
    }

    // Safely inserts a value into a sorted list while maintaining sorted order
    private List<Integer> insertSorted(List<Integer> list, int val) {
        List<Integer> res = new ArrayList<>(list.size() + 1);
        int i = 0;
        while (i < list.size() && list.get(i) < val) {
            res.add(list.get(i));
            i++;
        }
        res.add(val);
        while (i < list.size()) {
            res.add(list.get(i));
            i++;
        }
        return res;
    }

    // Tie-breaker comparator logic
    private boolean isBetter(long w1, List<Integer> l1, long w2, List<Integer> l2) {
        if (w1 != w2) {
            return w1 > w2;
        }
        int minLen = Math.min(l1.size(), l2.size());
        for (int i = 0; i < minLen; i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return l1.get(i) < l2.get(i);
            }
        }
        return l1.size() < l2.size();
    }
}
