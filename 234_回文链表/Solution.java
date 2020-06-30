/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-06-30 10:14:23
 * @FilePath: \leetcode\234_回文链表\Solution.java
 * @LastEditTime: 2020-06-30 10:29:06
 */ 
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
class Solution {
    ListNode pre;
    public boolean isPalindrome(ListNode head) {
        pre = head;
        return order_list(head);
    }
    /**
     * @Descripttion:判断是否回文 
     * @param {type} 
     * @return: 
     */
    public boolean order_list(ListNode head){
        if(head==null){
            return true;
        }
        // System.out.println(head.val); //前序遍历
        boolean res = order_list(head.next) && (pre.val==head.val);
        pre = pre.next;
        return res;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new Solution().isPalindrome(head));
    }
}