/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-07-07 09:42:23
 * @FilePath: \leetcode\112_路径总和\Solution.java
 * @LastEditTime: 2020-07-07 10:02:03
 */ 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left==null && root.right ==null){
            return sum == root.val; //叶子节点
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}