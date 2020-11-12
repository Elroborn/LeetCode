/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-11-12 09:32:22
 * @FilePath: \leetcode\剑指 Offer 26. 树的子结构\Solution.java
 * @LastEditTime: 2020-11-12 09:53:32
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean res = false;
        if(A!=null && B!=null){
            if(A.val == B.val){
                res = helper(A,B); // 先找到一个相等的根节点
            }
            if(!res){
                res = isSubStructure(A.left, B);
            }
            if(!res){
                res = isSubStructure(A.right, B);
            }
        }
        return res;
    }

    private boolean helper(TreeNode a, TreeNode b) { // 在判断左右结构
        if(b==null){
            return true;
        }
        if(a==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }
        return helper(a.left, b.left) && helper(a.right, b.right);
    }
}