/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-05 10:48:09
 * @FilePath: \leetcode\141_环形链表\Solution.java
 * @LastEditTime: 2020-07-05 10:53:46
 */ 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(p!=q && p!=null && q!=null && q.next!=null){
            p = p.next;
            q = q.next.next;
        }
        if(p==q){
            return true;
        }else{
            return false;
        }
    }
}