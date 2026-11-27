class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];
        int minPrice = Integer.MAX_VALUE;

        // 1. Precompute free copies granted by buying at least one copy of item i
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        // 2. 0/1 Knapsack for buying the first copy of each item type
        // dp[c] = max items obtained (first copies + free copies) using exact cost c
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int val = 1 + free[i];
            
            // Iterate backwards to ensure each item's free bonus is used at most once
            for (int c = budget; c >= price; c--) {
                if (dp[c - price] != -1) {
                    dp[c] = Math.max(dp[c], dp[c - price] + val);
                }
            }
        }

        // 3. Spend any remaining budget on the cheapest item (value = 1 per copy)
        int maxItems = 0;
        for (int c = 0; c <= budget; c++) {
            if (dp[c] != -1) {
                int extraCopies = (budget - c) / minPrice;
                maxItems = Math.max(maxItems, dp[c] + extraCopies);
            }
        }

        return maxItems;
    }
}