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
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        int sum = 0 , crr = 0;
        for(int i = list.size() -1 ; i >= 0 ; i--){
            if(list.get(i) == 1){
               sum += Math.pow(2 , crr);
            }
            crr++;
        }
        return sum;
    }
}