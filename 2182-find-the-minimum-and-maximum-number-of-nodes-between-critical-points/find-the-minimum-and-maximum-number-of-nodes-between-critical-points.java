/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         // A linked list must have at least 3 nodes to contain any critical point
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCpIndex = -1;
        int prevCpIndex = -1;
        
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        // Initialize pointers to traverse the list
        ListNode prev = head;
        ListNode curr = head.next;
        int currIndex = 1; // 0-indexed position tracker

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            // Check if the current node is a local maxima or local minima
            boolean isMaxima = curr.val > prev.val && curr.val > nextNode.val;
            boolean isMinima = curr.val < prev.val && curr.val < nextNode.val;

            if (isMaxima || isMinima) {
                if (firstCpIndex == -1) {
                    // Mark the very first critical point found
                    firstCpIndex = currIndex;
                } else {
                    // Update minDistance with the distance between adjacent critical points
                    minDistance = Math.min(minDistance, currIndex - prevCpIndex);
                    // Update maxDistance with the distance from the first critical point
                    maxDistance = currIndex - firstCpIndex;
                }
                // Keep track of the most recent critical point index
                prevCpIndex = currIndex;
            }

            // Move pointers forward
            prev = curr;
            curr = nextNode;
            currIndex++;
        }

        // If fewer than 2 critical points were found, maxDistance remains -1
        if (maxDistance == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}