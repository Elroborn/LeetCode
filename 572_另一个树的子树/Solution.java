 // Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSame(TreeNode a,TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        if(isSame(s, t)==true){
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        System.out.println(new Solution().isSubtree(root, t));
    }
}