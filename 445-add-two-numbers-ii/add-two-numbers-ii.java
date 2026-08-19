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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode l11 = Reverse(l1);
        ListNode l22 = Reverse(l2);
        ListNode dummy = new ListNode();
        ListNode current =dummy;
        int carry = 0;
        while(l11 != null || l22 !=null || carry != 0){
            int x = l11 != null ? l11.val : 0;
            int y = l22 != null ? l22.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            int digit = sum % 10;
            current.next = new ListNode(digit);
            current = current.next;
            if( l11 != null)
             l11 = l11.next;
            if( l22 != null)
             l22 = l22.next;
        }
        ListNode gudu = Reverse(dummy.next);
        return gudu;
    }
    private ListNode Reverse(ListNode l){
        if(l == null)
         return l;
        ListNode current = l;
        ListNode prev = null;
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}