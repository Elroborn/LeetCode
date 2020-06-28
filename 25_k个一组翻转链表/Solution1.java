/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-06-28 11:08:24
 * @FilePath: \leetcode\25_k个一组翻转链表\Solution1.java
 * @LastEditTime: 2020-06-28 14:17:03
 */ 
 //Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode a,b;
        a = b = head;
        for(int i=0;i<k;i++){
            if(b==null){
                return head;
            }
            b = b.next;
        }
        ListNode head_new = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return head_new;
   
    }
    public ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        while(cur!=b){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head = new Solution1().reverseKGroup(head, 0);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}