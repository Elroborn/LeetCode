/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-06 10:31:14
 * @FilePath: \leetcode\剑指 Offer 07. 重建二叉树\Solution.java
 * @LastEditTime: 2020-10-06 10:52:24
 */
//  Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder,int p_left,int p_right, int[] inorder,int i_left,int i_right){
        if(p_left>p_right || i_left>i_right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_left]);
        int i = i_left;
        for(;i<=i_right;i++){ //这一步主要目的是找到前序中这个元素在中序中的下标，所以可以将中序的{inorder[j]:j}做成hashmap，这样每次拿到元素可以直接定位到其下标
            if(inorder[i]==preorder[p_left]){
                break;
            }
        }
        int left_nodes = i - i_left;
        root.left = buildTree(preorder,p_left+1,p_left+left_nodes,inorder,i_left,i-1);
        root.right = buildTree(preorder, p_left+left_nodes+1,p_right,inorder,i+1,i_right);
        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new Solution().buildTree(preorder, inorder);
    }
}