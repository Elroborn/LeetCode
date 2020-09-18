/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-16 11:22:33
 * @FilePath: \leetcode\142_环形链表 II\Solution.java
 * @LastEditTime: 2020-09-16 11:31:15
 */
// Definition for singly-linked list.
import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode p = head;
        int i = 0;
        while(p!=null){
            if(map.containsKey(p)){
                return p;
            }else{
                map.put(p, i++);
                p = p.next;
            }
        }
        return null;
    }
}