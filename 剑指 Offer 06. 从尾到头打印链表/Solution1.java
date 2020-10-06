import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-06 10:07:48
 * @FilePath: \leetcode\剑指 Offer 06. 从尾到头打印链表\Solution1.java
 * @LastEditTime: 2020-10-06 10:24:59
 */
//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution {
    // public int[] reversePrint(ListNode head) {
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     while(head!=null){
    //         stack.push(head.val);
    //         head = head.next;
    //     }
    //     int[] res = new int[stack.size()];
    //     int i = 0;
    //     while(!stack.isEmpty()){
    //         res[i++] = stack.pop();
    //     }
    //     return res;

    // }
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        dfs(list,head);
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(List<Integer> list, ListNode head) {
        if(head==null){
            return;
        }
        dfs(list, head.next);
        list.add(head.val);
    }
}