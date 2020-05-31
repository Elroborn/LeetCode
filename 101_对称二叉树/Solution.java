 // Definition for a binary tree node.
class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        else{
            return isSymmetric(root.left,root.right);
        }
        
    }
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        // 都是非null
        return left.val==right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}