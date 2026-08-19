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
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int count = 0;
        while(current != null){
           count += 1;
           current = current.next;
        }

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0 ; i <= count / 2 ; i++)
         fast = fast.next;
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
       if(count % 2 != 0)
         head = slow;
       else 
        head = slow.next;

        return head;
    }
}