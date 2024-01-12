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

        ListNode curr = new ListNode(0);
        ListNode dummy = curr;


        int suma = howMuch(head);
        if(n == suma){
            return head.next;
        }



      for(int i = 0; i <(suma); i++){
          if(i == suma - n){
              head = head.next;

          }else {
              dummy.next = head;
              head = head.next;
              dummy = dummy.next;
          }
      }
      dummy.next = null;
      return curr.next;
    }

    private int howMuch( ListNode head){
        int suma = 0;
        while(head!=null){
            suma++;
            head = head.next;
        }
        return suma;
    }
}