import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
class Solution {
    public void inOrder(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(new Solution().isValidBST(root));
    }
}