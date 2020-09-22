import java.util.List;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-09-21 10:22:36
 * @FilePath: \leetcode\538_把二叉搜索树转换为累加树\Solution.java
 * @LastEditTime: 2020-09-21 14:39:09
 */
// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[] res = new int[1];
        InOrder(root, res);
        return root;
    }
    public void InOrder(TreeNode root,int[] res){
        if(root ==null){
            return;
        }
        InOrder(root.right, res);
        res[0]+=root.val;
        root.val = res[0];
        System.out.println(root.val);
        InOrder(root.left, res);
        
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        new Solution().convertBST(root);
    }
}