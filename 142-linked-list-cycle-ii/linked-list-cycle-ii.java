/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head , fast = head;
        boolean hascycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                hascycle = true;
                break;
            }
        }
        if(!hascycle){
            return null;
        }
         while(slow != fast){
                slow = slow.next;
                fast = fast.next;
        }
        return slow;
    }
}

/*
HashSet<ListNode> seen = new HashSet<>();
        ListNode crr = head;
        while(crr != null){
            if(seen.contains(crr)){
                return crr;
            }
            seen.add(crr);
            crr = crr.next;
        }
        return null;
*/