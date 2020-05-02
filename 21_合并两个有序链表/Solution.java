// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode rear = head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                rear.next = l1;
                rear = l1;
                l1 = l1.next;
                rear.next = null;
            }else{
                rear.next = l2;
                rear = l2;
                l2 = l2.next;
                rear.next = null;
            }
        }
        l1 = l1==null?l2:l1;
        while(l1!=null){
            rear.next = l1;
            rear = l1;
            l1 = l1.next;
            rear.next = null;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);

        ListNode ll = new Solution().mergeTwoLists(l1, l2);
        while(ll!=null){
            System.out.println(ll.val);
            ll = ll.next;
        }

    }
}