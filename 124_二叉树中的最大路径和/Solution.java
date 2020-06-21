 //Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
class Solution {
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        MaxGain(root);
        return max_sum;

    }
    public int MaxGain(TreeNode root){
        if(root==null){
            return 0;
        }
        int left_Gain = Math.max(MaxGain(root.left), 0);
        int right_Gain = Math.max(MaxGain(root.right), 0);
        max_sum = Math.max(max_sum,  root.val + left_Gain + right_Gain);
        return root.val + Math.max(left_Gain, right_Gain);
    }
}