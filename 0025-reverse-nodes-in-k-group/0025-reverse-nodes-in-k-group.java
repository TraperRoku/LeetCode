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
   public ListNode reverseKGroup(ListNode head, int k) {
    int n = howMuch(head);
    int ile = n/k;
    int temp = 0;

    ListNode node = new ListNode(-1);
    while(temp != ile){
        ListNode biznes = null;
      for(int i = 0; i < k ; i++){
          ListNode tempNode = head.next;
          head.next = biznes;
          biznes = head;
          head = tempNode;

      }
     joinListNode(node,biznes);
      temp++;
    }

    joinListNode(node,head);
return node.next;
    }

    private int howMuch( ListNode head){
        int suma = 0;
        while(head!=null){
            suma++;
            head = head.next;
        }
        return suma;
    }

    private void joinListNode(ListNode ls1, ListNode ls2){
    ListNode curr = ls1;
    while(curr.next!=null){
        curr = curr.next;
    }
    curr.next = ls2;

    }
}