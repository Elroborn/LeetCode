 //Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p = head;
        while(p!=null){
            ListNode q = p;
            while(q.next!=null){
                if(q.next.val == p.val){
                    // remove
                    q.next = q.next.next;
                }else{
                    q = q.next;
                }
            }
            p = p.next;
        }
        return head;
    }
}