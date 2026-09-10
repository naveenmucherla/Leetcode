/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Global tracker to count how many nodes match the condition
    private int matchingNodesCount = 0;

    public int averageOfSubtree(TreeNode root) {
        matchingNodesCount = 0; // Reset for safety
        calculateSumAndCount(root);
        return matchingNodesCount;
    }

    // This helper method returns an array of size 2: [subtree_sum, subtree_count]
    private int[] calculateSumAndCount(TreeNode current) {
        // Base case: An empty node has a sum of 0 and count of 0
        if (current == null) {
            return new int[]{0, 0};
        }

        // 1. Traverse left and right subtrees first (Post-Order)
        int[] leftResult = calculateSumAndCount(current.left);
        int[] rightResult = calculateSumAndCount(current.right);

        // 2. Combine the data for the current subtree
        int totalSum = leftResult[0] + rightResult[0] + current.val;
        int totalCount = leftResult[1] + rightResult[1] + 1;

        // 3. Check the average condition (integer division automatically rounds down)
        int average = totalSum / totalCount;
        if (current.val == average) {
            matchingNodesCount++;
        }

        // Return the combined metrics up to the parent node
        return new int[]{totalSum, totalCount};
    }
}

