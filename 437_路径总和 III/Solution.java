
// Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        return dfs(root, sum) +pathSum(root.left, sum) + pathSum(root.right, sum);

    }
    public int dfs(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        int curr = (root.val==sum)?1:0;
        int left = dfs(root.left, sum-root.val);
        int right = dfs(root.right, sum-root.val);
        return curr+left+right;

    }
}