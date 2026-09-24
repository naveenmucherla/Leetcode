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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy , crr = head;
        while(crr != null && crr.next != null){
            if(crr.val == crr.next.val){
                while(crr.next != null && crr.val == crr.next.val){
                    crr = crr.next;
                }
                prev.next = crr.next;
                crr = crr.next;
            }
            else{
                prev = crr;
                crr = crr.next;
            }
        }
        return dummy.next;
    }
}