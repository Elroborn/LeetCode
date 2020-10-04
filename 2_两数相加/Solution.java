/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-04 11:23:18
 * @FilePath: \leetcode\2_两数相加\Solution.java
 * @LastEditTime: 2020-10-04 11:31:17
 */
//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cnt = 0;
        int tmp = 0;
        ListNode head = new ListNode(-1);
        ListNode r = head;
        while(l1!=null && l2!=null){
            tmp+=(l1.val+l2.val+cnt);
            cnt=(tmp/10);
            ListNode p = new ListNode(tmp%10);
            r.next = p;
            r = p;
            tmp = 0;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2!=null){
            l1 = l2;
        }
        while(l1!=null){
            tmp+=(l1.val+cnt);
            cnt=(tmp/10);
            ListNode p = new ListNode(tmp%10);
            r.next = p;
            r = p;
            tmp = 0;
            l1 = l1.next;
        }
        if(cnt!=0){
            ListNode p = new ListNode(cnt);
            r.next = p;
            r = p;
        }
        return head.next;
        
    }
}