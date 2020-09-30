/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-30 09:11:17
 * @FilePath: \leetcode\701_二叉搜索树中的插入操作\Solution.java
 * @LastEditTime: 2020-09-30 09:22:14
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        helper(root, val);
        return root;
    }
    public void helper(TreeNode root, int val){

        if(val<root.val && root.left == null){
            root.left = new TreeNode(val);
            return;
        }
        if(val>root.val && root.right == null){
            root.right = new TreeNode(val);
            return;
        }

        if(val<root.val){
            helper(root.left, val);
        }else{
            helper(root.right, val);
        }
    }
}