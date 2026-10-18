class Solution {
    private static final long MOD = 1_000_000_007L;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        // Precompute Pascal's Triangle for combination coefficients C(n, k)
        long[][] table = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }

        // Convert the input array to a list for easier slicing during recursion
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Subtract 1 to exclude the original arrangement
        return (int) ((dfs(list, table) - 1 + MOD) % MOD);
    }

    private long dfs(List<Integer> list, long[][] table) {
        // Base case: if list has 2 or fewer elements, there's only 1 way to arrange it
        if (list.size() <= 2) {
            return 1;
        }

        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Partition elements into left and right subtrees
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        // Recursive results for subtrees
        long leftWays = dfs(left, table);
        long rightWays = dfs(right, table);

        // Calculate the number of ways to interleave left and right elements
        int totalElements = left.size() + right.size();
        long combinations = table[totalElements][left.size()];

        // Combine the results using modular multiplication
        return (((combinations * leftWays) % MOD) * rightWays) % MOD;
    }
}