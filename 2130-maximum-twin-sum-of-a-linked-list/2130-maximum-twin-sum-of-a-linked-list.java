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
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }

         int count = 0;

         ListNode mid  = reverse(slow);
         ListNode curr = head;

         while(mid != null && curr.next != null){
            
            count = Math.max(curr.val+mid.val ,count);

            curr = curr.next;
            mid= mid.next;
         }

        

     return count;
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}

     