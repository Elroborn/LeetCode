/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-26 09:03:40
 * @FilePath: \leetcode\剑指 Offer 24. 反转链表\Solution.java
 * @LastEditTime: 2020-09-26 09:06:37
 */

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode new_head = new ListNode(-1);
        ListNode p = head;
        while(p!=null){
            ListNode t = p.next;
            p.next = new_head.next;
            new_head.next = p;
            p = t;
        }
        return new_head.next;

    }
}