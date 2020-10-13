/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-13 16:05:59
 * @FilePath: \leetcode\24_两两交换链表中的节点\Solution1.java
 * @LastEditTime: 2020-10-13 16:37:36
 */
//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution1 {
    public ListNode swapPairs(ListNode head) {
        ListNode dunmpHead = new ListNode(-1);
        dunmpHead.next = head;
        ListNode pre = dunmpHead;
        while(pre.next!=null && pre.next.next!=null){ // pre.next一定不是null
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            pre = node1;
        }
        return dunmpHead.next;

    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        new Solution1().swapPairs(head);
    }
}