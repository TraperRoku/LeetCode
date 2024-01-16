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
       public ListNode mergeKLists(ListNode[] lists) {
     int n = lists.length;
     if(n==0) {
         ListNode listNode = null;
         return listNode;
     }else if(n==1){
         return lists[0];
     }else if(n==2){
           return mergeTwoLists(lists[0],lists[1]);
     }else{
         int mid = n/2;
         ListNode[] ls1 = Arrays.copyOfRange(lists, 0, mid);
         ListNode[] ls2 = Arrays.copyOfRange(lists, mid, n);
         return mergeTwoLists(mergeKLists(ls1),mergeKLists(ls2));
     }
    }
    
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     ListNode biznes = new ListNode(-1);
     ListNode curr  = biznes;

     if(list1 == null) return list2;
     if(list2 == null) return list1;

     while(list1!=null && list2!=null){
         if(list1.val > list2.val){
             curr.next = list2;
             list2 = list2.next;
         }else{
             curr.next = list1;
             list1 = list1.next;
         }
         curr = curr.next;
     }
     if(list1 == null){
         curr.next = list2;
     }else{
         curr.next = list1;
     }
     return biznes.next;
    }
}