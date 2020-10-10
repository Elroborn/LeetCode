import java.util.HashSet;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-10 09:36:45
 * @FilePath: \leetcode\142_环形链表 II\Solution1.java
 * @LastEditTime: 2020-10-10 11:06:36
 */
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Solution1 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p = head;
        while(p!=null){
            if(set.contains(p)){
                return p;
            }else{
                set.add(p);
            }
            p = p.next;
        }
        return null;
    }
}