/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-09 14:34:51
 * @FilePath: \leetcode\141_环形链表\Solution1.java
 * @LastEditTime: 2020-10-09 16:09:04
 */
//  Definition for singly-linked list.
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode p = head;
        ListNode q = p.next;
        while(q!=null && q.next !=null){
            if(p==q){
                return true;
            }
            p = p.next;
            q = q.next.next;
        }
        return false;
    }
}