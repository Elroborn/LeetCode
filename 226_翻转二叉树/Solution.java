/*
 * @Author: your name
 * @Date: 2020-09-16 10:24:44
 * @LastEditTime: 2020-09-16 10:33:40
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \leetcode\226_翻转二叉树\Solution.java
 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        helper(root.right);
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
}