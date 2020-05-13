import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a binary tree node.
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left; // 一直向左
            }
            curr = stack.pop(); //根
            res.add(curr.val);
            curr = curr.right; //右
        }
        return res;

    }
}