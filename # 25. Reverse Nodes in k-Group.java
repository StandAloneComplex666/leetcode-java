/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = findLen(head);
        //find number of times that while loop will run (number of k-groups)
        int groups = len/k;
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(head != null && groups > 0){
            //reverse the current k group
            //current head will be the last element added to reversed list
            ListNode currTail = head;
            for(int i = 0; i < k && head != null; i++){
                ListNode tmp = ptr.next;
                ptr.next = head;
                head = head.next;
                ptr.next.next = tmp;
                
            }
            //move ptr to end of k-group that was just added
            ptr = currTail;
            groups--;
        }
        //if number of nodes was not multiple of k then attach remaining head
        if(head != null){
            ptr.next = head;
        }
        return dummy.next;
        
    }
    
    private int findLen(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}