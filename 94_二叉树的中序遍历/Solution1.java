import java.util.ArrayList;
import java.util.List;

/*
 * @Author: your name
 * @Date: 2020-09-14 10:12:12
 * @LastEditTime: 2020-09-14 10:14:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \leetcode\94_二叉树的中序遍历\Solution1.java
 */
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if(root==null){
            return ;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}