class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode res = lists[0];
        for(int i=1;i<lists.length;i++){
            res = merge(res, lists[i]);
        }
        return res;

    }
    public ListNode merge(ListNode l1,ListNode l2){ //结果存到
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
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        ListNode[] lists = {l1,l2};
        l1 = new Solution().mergeKLists(lists);
        while(l1!=null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}