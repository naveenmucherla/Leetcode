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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current1 = list1;
        ListNode current2 = list2;
        ListNode head = null;
        while(current1 != null && current2 != null){
            if(current1.val < current2.val ){
              head = insert(current1.val , head);
              current1 = current1.next;
            }
            else{
             head =  insert(current2.val , head);
             current2 = current2.next;
            }
        }
        while(current1 !=null){
         head = insert(current1.val , head);
         current1 = current1.next;
        }
        while(current2 != null){
         head = insert(current2.val , head);
         current2 = current2.next;
        }
        return head;
    }
    private ListNode insert(int val , ListNode head){
        ListNode current = head;
         
        if(head == null){
            ListNode node1 = new ListNode(val);
            head = node1;
            node1.next = null;
        }
        else{
            while(current.next != null){
                current = current.next;
            }
            ListNode node = new ListNode();
            node.val = val;
            node.next = null;
            current.next = node;
        }
        return head;
    }
}