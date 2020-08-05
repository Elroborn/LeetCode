import java.util.HashMap;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-05 10:11:04
 * @FilePath: \leetcode\337_打家劫舍 III\Solution.java
 * @LastEditTime: 2020-08-05 10:19:18
 */
// https://leetcode-cn.com/problems/house-robber-iii/solution/da-jia-jie-she-iii-by-leetcode-solution/
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    HashMap<TreeNode,Integer> f;
    HashMap<TreeNode,Integer> g;
    public int rob(TreeNode root) {
        f = new HashMap<>();
        g = new HashMap<>();
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }
    private void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0)); // root 被选中，则left和right不可选
        g.put(root, Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
    }
}