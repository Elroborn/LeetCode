/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-19 08:43:08
 * @FilePath: \leetcode\19_删除链表的倒数第N个节点\Solution.java
 * @LastEditTime: 2020-10-19 08:52:14
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode new_head = new ListNode(-1);
        new_head.next = head; //避免只有一个节点，删除不好删
        ListNode p = new_head;
        ListNode q = new_head;
        for(int i = 0;i<n && p!=null;i++){
            p = p.next;
        }
        while(p.next!=null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next==null?null:q.next.next; //删除
        return new_head.next;
    }
}