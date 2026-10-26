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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head.next == null) return null;

        int count =0 ;
        ListNode curr = head;
         
         while(curr != null){
            count++;
            curr = curr.next;
         }
         

         int  act = count -n;

         if(act  == 0){
            return head.next;
         }
         count =1;
         curr = head;
        

           while(curr != null && act > count){
             count++;
             curr = curr.next;
           }
          
          ListNode next = curr.next.next;
           

          if(next == null){
            curr.next = null;
          }
          else {
            curr.next = next;
          }

        return  head;
    }
}