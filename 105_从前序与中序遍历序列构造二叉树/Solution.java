 // Definition for a binary tree node.
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
    public TreeNode buildTree(int[] preorder,int l1,int r1,int[]inorder,int l2,int r2){
        if(l1>r1){
            return null;
        }
        TreeNode node = new TreeNode(preorder[l1]);
        int i=l2;
        for(i = l2;i<=r2;i++){
            if(inorder[i]==preorder[l1]){
                break;
            }
        }
        node.left = buildTree(preorder, l1+1, l1+i-l2, inorder, l2, i-1);
        node.right = buildTree(preorder, l1+i-l2+1, r1, inorder, i+1, r2);
        return node;
    }
}