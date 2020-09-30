import java.util.ArrayList;
import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-30 09:23:35
 * @FilePath: \leetcode\145_二叉树的后序遍历\Solution.java
 * @LastEditTime: 2020-09-30 09:54:29
 */
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }
    private void helper(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        helper(root.left, list);
        helper(root.right, list);
        list.add(root.val);
    }
 
}