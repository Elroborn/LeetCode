/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-13 16:05:59
 * @FilePath: \leetcode\24_两两交换链表中的节点\Solution.java
 * @LastEditTime: 2020-10-13 16:06:07
 */
//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode p = head, q = head.next;
        head = head.next;
        while(q!=null){
            ListNode t = q.next;
            if(q.next==null){
                p.next = null;
            }else{
                if(q.next.next==null){
                    p.next = q.next;
                }else{
                    p.next = q.next.next;
                }
            }
            q.next = p;
            p = t;
            q = t==null?null:t.next;
        }
        return head;
    }
}