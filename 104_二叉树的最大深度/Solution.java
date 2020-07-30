/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-28 11:05:59
 * @FilePath: \leetcode\104_二叉树的最大深度\Solution.java
 * @LastEditTime: 2020-07-28 11:10:36
 */ 

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root!=null && root.left == null && root.right ==null){
            return 1;
        }
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return 1 + Math.max(left_depth, right_depth);
    }
}