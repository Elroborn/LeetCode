/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-18 10:16:18
 * @FilePath: \leetcode\109_有序链表转换二叉搜索树\Solution.java
 * @LastEditTime: 2020-08-18 10:23:37
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
//  Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null); // [left,right) 包前不包后，这样方便下面mid，如果包前包后，mid的前面节点不易获取； 当前包前不包后所以注意边界是== return
    }
    public TreeNode build(ListNode left,ListNode right){
        if(left == right){
            return null;
        }
        ListNode mid = getMid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(left, mid);
        root.right = build(mid.next, right);
        return root;
    }
    public ListNode getMid(ListNode left,ListNode right){
        ListNode slow = left,fast = left;
        while(fast!=right && fast.next !=right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        } // fast刚好是slow二倍，所以fast到尾部，slow在中间
        return slow;
    }
}