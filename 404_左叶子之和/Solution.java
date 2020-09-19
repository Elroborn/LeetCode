
/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-19 09:49:04
 * @FilePath: \leetcode\404_左叶子之和\Solution.java
 * @LastEditTime: 2020-09-19 10:21:27
 */
//  Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return sumOf(root);
        }
    }
    public int sumOf(TreeNode root){
        int res = 0;
        if(root.left!=null){
            if(isLeaf(root.left)){
                res+=root.left.val;
            }else{
                res+=sumOf(root.left);
            }
        }
        if(root.right!=null && !isLeaf(root.right)){
            res+=sumOf(root.right);
        }
        return res;
    }
    public boolean isLeaf(TreeNode node){
        if(node.left==null && node.right==null){
            return true;
        }else{
            return false;
        }
    }
}