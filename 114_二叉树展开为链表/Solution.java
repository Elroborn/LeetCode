/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-02 10:42:53
 * @FilePath: \leetcode\114_二叉树展开为链表\Solution.java
 * @LastEditTime: 2020-08-02 10:52:54
 */ 
import java.util.List;
import java.util.ArrayList;
//Definition for a binary tree node.
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
    private List<TreeNode> preVis = new ArrayList<>();
    public void flatten(TreeNode root) {
        pre(root);
        if(preVis.size() == 0 || preVis.size()==1){
            return;
        }
        for(int i = 1;i<preVis.size();i++){
            preVis.get(i-1).left = null;
            preVis.get(i-1).right = preVis.get(i);
        }
    }
    private void pre(TreeNode root){
        if(root == null){
            return ;
        }
        preVis.add(root);
        pre(root.left);
        pre(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        new Solution().flatten(root);
    }

}