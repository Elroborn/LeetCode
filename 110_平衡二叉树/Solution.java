/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-17 10:03:33
 * @FilePath: \leetcode\110_平衡二叉树\Solution.java
 * @LastEditTime: 2020-08-17 10:35:49
 */
// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        int left_h = getHeight(root.left);
        int right_h = getHeight(root.right);
        return Math.abs(left_h - right_h)<=1 && isBalanced(root.left) && isBalanced(root.right);

    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) +1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(new Solution().isBalanced(root));
    }
}