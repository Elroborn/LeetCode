/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-12 11:27:08
 * @FilePath: \leetcode\剑指 Offer 06. 从尾到头打印链表\Solution.java
 * @LastEditTime: 2020-10-06 10:13:50
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public int[] reversePrint(ListNode head) {
        //或者用栈 后进先出的特性，遍历一遍链表，然后再出栈
        ListNode new_head = new ListNode(-1);
        int len = 0;
        while(head!=null){
            ListNode t = head.next;
            head.next = new_head.next;
            new_head.next = head;
            head = t;
            len++;
        }
        int[] res = new int[len];
        int i = 0;
        new_head = new_head.next;
        while(new_head!=null){
            res[i++] = new_head.val;
            new_head = new_head.next;
        }
        return res;
    }
}