/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode pre = new ListNode(0);
        ListNode d = pre;
        int sum = 0;
        
        while (t1 != null || t2 != null){
            if (t1 != null){
                sum += t1.val;
                t1 = t1.next;
            }
            if (t2 != null){
                sum += t2.val;
                t2 = t2.next;
            }
            d.next = new ListNode(sum % 10);
            sum /= 10;
            d = d.next;
        }
        if (sum == 1) d.next = new ListNode(1);
        return pre.next;
    }
}