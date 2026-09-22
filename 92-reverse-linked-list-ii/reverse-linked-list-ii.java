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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right || head.next == null){
            return head;
        }
      ListNode crr = head, prev = null;
      int count = 1;
      while(count < left){
        prev =crr;
        crr = crr.next;
        count ++;
      }
      ListNode crr1 = crr , after , rev_head = null;
      while(count <= right){
        after = crr1.next;
        crr1.next = rev_head;
        rev_head = crr1;
        crr1 = after;
        count++;
      }
      if(prev == null){
        head = rev_head;
      }
      else{
        prev.next = rev_head;
      }
       crr.next = crr1;


        return head;
    }
}