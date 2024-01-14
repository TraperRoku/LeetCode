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

        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;
        boolean flag = false;
        int mnozenie = 0;

while(l1 != null || l2 !=null){
    int suma = 0;
    if(l1 == null) suma = l2.val;
    else if(l2 == null) suma = l1.val;
    else suma = l1.val + l2.val;
    int reszta = (suma+mnozenie) % 10;

    if(suma + mnozenie>9 ){
        curr.next = new ListNode(reszta);
        flag = true;
        mnozenie = (suma + mnozenie) / 10;
    }else if(flag){
        curr.next = new ListNode(suma+mnozenie);
        flag = false;
        mnozenie = 0;
    }else{
        curr.next = new ListNode(suma);
    }
    curr = curr.next;
    if(l1!= null) l1 = l1.next;
    if(l2!=null) l2 = l2.next;

}if (mnozenie > 0) curr.next = new ListNode(mnozenie);
        
return listNode.next;

    }

}