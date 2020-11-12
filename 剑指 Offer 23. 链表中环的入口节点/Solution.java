/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-09 08:56:51
 * @FilePath: \leetcode\剑指 Offer 23. 链表中环的入口节点\Solution.java
 * @LastEditTime: 2020-11-09 10:44:22
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
}
public class Solution{
    ListNode meetNode(ListNode head){
        if(head==null){
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q!=null && q.next!=null && p!=q){
            p = p.next;
            q = q.next.next;
        }
        if(p==q){
            return p;
        }else{
            return null;
        }
    }
    ListNode entryNode(ListNode head){
        ListNode mNode = meetNode(head);
        if(mNode==null){
            return null; // 无环
        }
        //确定环内节点个数
        int num = 1;
        ListNode p = mNode.next;
        while(p!=mNode){ // mNode 在环内，所以一定会转一圈
            p = p.next;
            num++;
        }

        //用快慢指针，fast比slow快num个，这样到时候在环中，如果两个节点相遇，说明fast比slow刚好多一圈
        
        return null;
        
        
    }
    
}