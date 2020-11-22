/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-20 10:16:57
 * @FilePath: \leetcode\147_对链表进行插入排序\Solution.java
 * @LastEditTime: 2020-11-20 10:30:00
 */
// Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode new_head = new ListNode(Integer.MIN_VALUE);
        ListNode p = head;
        while(p!=null){
            ListNode i = new_head;
            while(i.val<p.val && i.next!=null && i.next.val<p.val){
                i = i.next;
            }
            ListNode t = p.next;
            p.next = i.next;
            i.next = p;
            p = t;
        }
        return new_head.next;
    }
}