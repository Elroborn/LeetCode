import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-20 08:33:52
 * @FilePath: \leetcode\143_重排链表\Solution.java
 * @LastEditTime: 2020-10-20 09:12:35
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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null){
            list.add(p);
            p = p.next;
        }
        ListNode new_head = new ListNode(-1);
        ListNode r = new_head;
        // 这个部分可以双指针 这个代码核心思想就是将非随机访问变为随机访问
        for(int i = 0;i<=list.size()/2-1+list.size()%2;i++){
            ListNode t1 = list.get(i);
            r = insert(r, t1);
            if(list.size()-i-1>i){
                ListNode t2 = list.get(list.size()-i-1);
                r = insert(r, t2);
            }
        }
    }
    private ListNode insert(ListNode rear,ListNode node){
        node.next = rear.next;
        rear.next = node;
        rear = node;
        return rear;
    }
}